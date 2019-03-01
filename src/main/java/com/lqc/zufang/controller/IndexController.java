package com.lqc.zufang.controller;

import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.entity.HouseResourceQuery;
import com.lqc.zufang.entity.User;
import com.lqc.zufang.service.HouseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
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
    @RequestMapping("/index")
    public String index(Model model) {
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
        System.out.println("size:" + list.size());
        System.out.println(list.get(0).get(0).getId());
        model.addAttribute("list", list);
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
