package com.lqc.zufang.controller;

import com.lqc.zufang.entity.HouseResource;
import com.lqc.zufang.entity.User;
import com.lqc.zufang.service.HouseResourceService;
import com.lqc.zufang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 11:08
 */
@Controller
@RequestMapping()
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HouseResourceService houseResourceService;

    /**
     * 跳转到用户中心页面时要展示用户的收藏列表
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/user")
    public String userCenter(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        List<Long> houseIds = userService.getHouseIdsByUser(user.getUsername());
        List<HouseResource> houseResourceList = new ArrayList<>();
        //获取用户的收藏列表
        for (Long houseId : houseIds) {
            houseResourceList.add(houseResourceService.getHouseResourceById(houseId));
        }
        List<List<HouseResource>> list=new ArrayList<>();
        int size=houseResourceList.size();
        int tsize=size;
        while(tsize!=0){
            int i=0;
            List<HouseResource> temp=new ArrayList<>();
            while(i<3&&tsize>0){
                temp.add(houseResourceList.get(size-tsize));
                i++;
                tsize--;
            }
            list.add(temp);
        }
        model.addAttribute("list",list);
        return "/admin/user";
    }


    /**
     * 用户在个人中心页面取消收藏
     *
     * @param id      房源id
     * @param session
     * @return
     */
    @RequestMapping("/ucancelcollect")
    public String cancelcollect(@RequestParam("id") Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        userService.cancelcollect(id, user.getId());
        return "redirect:user?id=" + user.getId();
    }


}
