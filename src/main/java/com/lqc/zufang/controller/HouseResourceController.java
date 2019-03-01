package com.lqc.zufang.controller;

import com.lqc.zufang.entity.Collect;
import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.entity.User;
import com.lqc.zufang.service.HouseResourceService;
import com.lqc.zufang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 17:02
 */
@Controller
@RequestMapping
public class HouseResourceController {
    @Autowired
    HouseResourceService houseResourceService;
    @Autowired
    UserService userService;
    /**
     * 根据房源id查询对应房源的信息,同时给出前三收藏量的房源进行推荐
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/house",method = RequestMethod.GET)
    public String getHouseResource(@RequestParam(value = "id",required = false)Long id, Model model){
        HouseResource houseResource=houseResourceService.getHouseResourceById(id);
        model.addAttribute("houseResource",houseResource);
        //获取房东信息
        System.out.println(houseResource.getBelonguser());
        User landlord=userService.getUserById(houseResource.getBelonguser());
        model.addAttribute("landlord",landlord);
        return "admin/houseDetail";
    }

    /**
     * 添加房源到用户的收藏
     * @param session
     * @param id 传过来的房源id
     */
    @RequestMapping("/collect")
    public void collect(HttpSession session,
                        @RequestParam("id")String id){
        User user=(User)session.getAttribute("user");
        if(user!=null){
            Collect collect=new Collect();
            collect.setUserId(user.getId());
            collect.setHouseId(Long.valueOf(id));
            houseResourceService.insertCollect(collect);
        }
    }
}
