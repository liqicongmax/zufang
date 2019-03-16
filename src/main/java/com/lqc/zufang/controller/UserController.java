package com.lqc.zufang.controller;

import com.lqc.zufang.entity.User;
import com.lqc.zufang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 11:08
 */
@Controller
@RequestMapping()
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public String userCenter(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "/admin/user";
    }

    /**
     * TODO:个人中心页面的我的收藏未做
     */

    /**
     * 用户在个人中心页面取消收藏
     * @param id 房源id
     * @param session
     * @return
     */
    @RequestMapping("/ucancelcollect")
    public String cancelcollect(@RequestParam("id") Long id, HttpSession session) {
        User user=(User)session.getAttribute("user");
        userService.cancelcollect(id,user.getId());
        return "redirect:house?id="+id;
    }


}
