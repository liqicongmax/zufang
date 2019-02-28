package com.lqc.zufang.controller;

import com.lqc.zufang.base.BaseReturnDto;
import com.lqc.zufang.constant.Identity;
import com.lqc.zufang.entity.User;
import com.lqc.zufang.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/26 16:16
 */
@Controller
@RequestMapping
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    LoginService loginService;
    @RequestMapping("/gotoLogin")
    public String loginIndex(){
        return "login";
    }

    /**
     * 用户登录,接收表单提交内容
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("login-username") String username,
                        @RequestParam("login-password") String password,
                        Model model,
                        HttpSession session) {
        BaseReturnDto<Boolean> brd = new BaseReturnDto<>();
        User user = new User(username, password);
        System.out.println(username+""+password);
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
        session.setAttribute("user",user);
        return "redirect:index";
    }


    /**
     * 用户注册,接收表单提交内容
     * @param username
     * @param password
     * @throws Exception
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("register-username")String username,
                           @RequestParam("register-password")String password,
                           @RequestParam(value = "register-phonenumber",required = false)String phonenumber,
                           @RequestParam("register-email")String email)throws Exception{
        User user=new User(username,password);
        if(loginService.getUser(user)){
            System.out.println("用户名已被占用");
            throw new Exception("用户名已被占用!");
        }
        user.setPhonenumber(phonenumber);
        user.setEmail(email);
        System.out.println(user.toString());
        loginService.insert(user);
        Thread.sleep(3000);
        return "/login";
    }

    /**
     * 用户登录注销
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:index";
    }
}
