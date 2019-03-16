package com.lqc.zufang.service;

import com.lqc.zufang.entity.User;

import java.util.List;

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

    /**
     * 通过用户名来获取该用户收藏的所有房源
     * @param username
     * @return
     */
    List<Long> getHouseIdsByUser(String username);

    /**
     * 取消收藏
     * @param id
     * @param userid
     */
    void cancelcollect(Long id,Long userid);
}
