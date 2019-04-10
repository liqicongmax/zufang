package com.lqc.zufang.util;

import com.lqc.zufang.entity.User;

import javax.servlet.http.HttpSession;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/10 16:52
 */
public class LoginUtils {
    public static User getUser(HttpSession session){
        User user=(User)session.getAttribute("user");
        if(user!=null) {
            return user;
        }
        return null;
    }
}
