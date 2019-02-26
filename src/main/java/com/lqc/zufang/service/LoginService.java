package com.lqc.zufang.service;

import com.lqc.zufang.entity.User;

public interface LoginService {
    /**
     * 通过提交的user信息判断数据库中是否有用户信息,如果有,判断登录通过
     * @param user
     * @return
     */
    boolean getUser(User user);

    void insert(User user);
}
