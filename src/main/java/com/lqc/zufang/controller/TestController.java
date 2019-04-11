package com.lqc.zufang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/22 16:38
 */
@Controller
public class TestController {
    private Logger logger= LoggerFactory.getLogger(TestController.class);
    @RequestMapping("/showhome")
    public String showhome(){
        String name= SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登录用户"+name);
        return "home1";
    }
    @RequestMapping("/login1")
    public String showlogin(){
        return "login1";
    }
    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin(){
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @RequestMapping("/userr")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }
}
