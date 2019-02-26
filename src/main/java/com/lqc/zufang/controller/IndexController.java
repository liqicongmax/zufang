package com.lqc.zufang.controller;

import com.lqc.zufang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/26 16:16
 */
@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model){
        return "index";
    }

}
