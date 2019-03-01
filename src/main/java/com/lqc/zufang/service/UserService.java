package com.lqc.zufang.service;

import com.lqc.zufang.entity.User;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 11:16
 */
public interface UserService {
    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 通过username去数据库里找对应用户信息
     * @param username
     * @return
     */
    User getUserByUserName(String username);
}
