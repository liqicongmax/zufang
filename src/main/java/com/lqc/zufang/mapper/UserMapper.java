package com.lqc.zufang.mapper;

import com.lqc.zufang.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 通过用户名去数据库里查找对应用户
     * @param name 用户名
     * @return 用户信息
     */
    User getUserByName(String name);

    /**
     * 添加新注册的用户
     * @param user 用户实体
     */
    void insert(User user);
    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 通过用户名来获取用户收藏的所有房源
     * @param username
     * @return
     */
    List<Long> getHouseIdsByUser(String username);
}
