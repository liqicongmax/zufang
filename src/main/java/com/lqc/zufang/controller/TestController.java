package com.lqc.zufang.controller;

import com.lqc.zufang.util.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/22 16:38
 */
@Controller
public class TestController {
    private Logger logger= LoggerFactory.getLogger(TestController.class);

//    @RequestMapping("/test11")
//    @ResponseBody
//    public void test(HttpServletRequest request){
//        System.out.println(IPUtil.getIP(request));
//    }
}
