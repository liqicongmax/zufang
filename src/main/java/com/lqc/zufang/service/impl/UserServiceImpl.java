package com.lqc.zufang.service.impl;

import com.lqc.zufang.entity.User;
import com.lqc.zufang.mapper.UserMapper;
import com.lqc.zufang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/2/27 11:17
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    /**
     * 通过username去数据库里找对应用户信息
     *
     * @param username
     * @return
     */
    @Override
    public User getUserByUserName(String username) {
        return userMapper.getUserByName(username);
    }

    /**
     * 通过用户名来获取该用户收藏的所有房源
     *
     * @param username
     * @return
     */
    @Override
    public List<Long> getHouseIdsByUser(String username) {
        return userMapper.getHouseIdsByUser(username);
    }
}
