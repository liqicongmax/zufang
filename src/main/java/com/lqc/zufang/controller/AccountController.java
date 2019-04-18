package com.lqc.zufang.controller;

import com.lqc.zufang.entity.Role;
import com.lqc.zufang.service.RoleService;
import com.lqc.zufang.util.LoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/18 13:30
 */
@Controller
public class AccountController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/toMyAccount")
    public String toMyAccount(HttpSession session, Model model){
        Role role=roleService.selectById(LoginUtils.getUser(session).getId().intValue());
        model.addAttribute("role",role);
        return "admin/myAccount";
    }
}
