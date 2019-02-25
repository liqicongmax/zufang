package com.lqc.zufang.controller;

import com.lqc.zufang.base.BaseReturnDto;
import com.lqc.zufang.entity.User;
import com.lqc.zufang.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        BaseReturnDto<Boolean> brd = new BaseReturnDto<>();
        User user = new User(username, password);
        try {
            if (loginService.getUser(user)) {
                brd = new BaseReturnDto<>(1, "登录成功", true);
                System.out.println("成功");
            } else {
                brd = new BaseReturnDto<>(-1, "登录失败", false);
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            brd = new BaseReturnDto<>(-1, "fail");
            logger.error("failed to login");
        }
        model.addAttribute("result", brd);
        return "index";
    }

}
