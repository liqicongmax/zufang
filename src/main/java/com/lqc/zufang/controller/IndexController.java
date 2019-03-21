package com.lqc.zufang.controller;

import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.entity.HouseResourceQuery;
import com.lqc.zufang.entity.User;
import com.lqc.zufang.service.HouseResourceService;
import com.lqc.zufang.util.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
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

    /**
     * 首页展示,展示收藏量前六的房源
     * 把房源组装成List<List<HouseResource>>的形式,里面3个一组
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/index",""})
    public String index(Model model, HttpServletRequest request) {
        List<HouseResource> houseResourceList = houseResourceService.getHouseResourceListLimitSix();
        List<List<HouseResource>> list = new ArrayList<>(2);
        List<HouseResource> temp = new ArrayList<>(3);
        List<HouseResource> temp1 = new ArrayList<>(3);
        int i = 0;
        for (HouseResource houseResource : houseResourceList) {
            i++;
            if (i <= 3) {
                temp.add(houseResource);
            } else {
                temp1.add(houseResource);
            }
        }
        list.add(temp);
        list.add(temp1);
        model.addAttribute("list", list);
        //String ip=IPUtil.getClientIp(request);
        //System.out.println("-------------------"+ip+"============================");
        String ip=" 101.71.41.228";
        try {
            String json_result = IPUtil.getAddresses("ip=" + ip, "utf-8");
            System.out.println(json_result);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if(!low.equals("any")) {
            houseResourceQuery.setLow(Integer.valueOf(low));
        }
        if(!high.equals("any")) {
            houseResourceQuery.setHigh(Integer.valueOf(high));
        }
        List<HouseResource> resources = houseResourceService.query(houseResourceQuery);
        List<List<HouseResource>> list = new ArrayList<>();
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
        model.addAttribute("list",list);
        return "search";
    }
}
