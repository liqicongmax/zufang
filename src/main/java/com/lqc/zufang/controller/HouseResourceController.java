package com.lqc.zufang.controller;

import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.service.HouseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 17:02
 */
@Controller
@RequestMapping
public class HouseResourceController {
    @Autowired
    HouseResourceService houseResourceService;

    /**
     * 根据房源id查询对应房源的信息,同时给出前三收藏量的房源进行推荐
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/house",method = RequestMethod.GET)
    public String getHouseResource(@RequestParam(value = "id",required = false)Long id, Model model){
        HouseResource houseResource=houseResourceService.getHouseResourceById(id);
        return "admin/houseDetail";
    }
}
