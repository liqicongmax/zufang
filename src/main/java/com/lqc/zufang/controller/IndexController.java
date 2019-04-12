package com.lqc.zufang.controller;

import com.alibaba.fastjson.JSONObject;
import com.lqc.zufang.entity.Data;
import com.lqc.zufang.entity.Ip2Address;
import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.entity.HouseResourceQuery;
import com.lqc.zufang.service.HouseResourceService;
import com.lqc.zufang.util.IPUtil;
import com.lqc.zufang.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/26 16:16
 */
@Controller
@RequestMapping("")
public class IndexController {
    @Autowired
    HouseResourceService houseResourceService;
    @Autowired
    RedisUtil redisUtil;


    /**
     * 首页展示,展示收藏量前六的房源
     * 把房源组装成List<List<HouseResource>>的形式,里面3个一组
     *先根据当前ip所在的地址去获取相关地址的房源信息,展示收藏量的前六条,如果没有,就展示当前收藏量前6的房源信息
     * @param model
     * @return
     */
    @RequestMapping(value = {"/index", ""})
    public String index(Model model, HttpSession session) {
        List<HouseResource> houseResourceList=new ArrayList<>();
        String ip = "101.71.41.228";
        //ip="125.114.238.231";
        Ip2Address ip2Address =(Ip2Address)redisUtil.get(ip);
        if(ip2Address ==null){
            System.out.println("我返回没东西!");
            try {
                ip2Address = JSONObject.parseObject(IPUtil.getAddresses("ip=" + ip, "utf-8"), Ip2Address.class);
                redisUtil.set(ip,ip2Address);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("=============="+ip2Address.getData().getCity());
        HouseResourceQuery query=new HouseResourceQuery();
        query.setProvince(ip2Address.getData().getRegion());
        query.setCity(ip2Address.getData().getCity());
        List<HouseResource> result=houseResourceService.query(query);
        if(result.size()!=0){
            houseResourceList.addAll(result);
        }else {
            houseResourceList = houseResourceService.getHouseResourceListLimitSix();
        }
        List<List<HouseResource>> list = getList(houseResourceList);
        model.addAttribute("list", list);
        //String ip=IPUtil.getClientIp(request);
        //System.out.println("-------------------"+ip+"============================");
        Data data=ip2Address.getData();
        model.addAttribute("address",data);
        session.setAttribute("address",data);
        return "index";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("province") String province,
                         @RequestParam("city") String city,
                         @RequestParam("district") String district,
                         @RequestParam(value = "low", required = false) String low,
                         @RequestParam(value = "high", required = false) String high,
                         Model model) {
        HouseResourceQuery houseResourceQuery = new HouseResourceQuery();
        houseResourceQuery.setProvince(province);
        houseResourceQuery.setCity(city);
        houseResourceQuery.setDistrict(district);
        if (!low.equals("any")) {
            houseResourceQuery.setLow(Integer.valueOf(low));
        }
        if (!high.equals("any")) {
            houseResourceQuery.setHigh(Integer.valueOf(high));
        }
        List<HouseResource> resources = houseResourceService.query(houseResourceQuery);
        List<List<HouseResource>> list = getList(resources);
        model.addAttribute("list", list);
        return "search";
    }

    /**
     * 公共方法,把查询到的房源信息按照给定的格式写入到list
     * @param resources 房源信息列表
     * @return 格式化后的房源信息
     */
    private List<List<HouseResource>> getList(List<HouseResource> resources){
        List<List<HouseResource>> list=new ArrayList<>();
        List<HouseResource> temp = new ArrayList<>(3);
        List<HouseResource> temp1 = new ArrayList<>(3);
        int i = 0;
        for (HouseResource houseResource : resources) {
            i++;
            if (i <= 3) {
                temp.add(houseResource);
            } else {
                temp1.add(houseResource);
            }
        }
        list.add(temp);
        list.add(temp1);
        return list;
    }
}
