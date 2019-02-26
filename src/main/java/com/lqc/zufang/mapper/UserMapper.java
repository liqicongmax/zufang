package com.lqc.zufang.mapper;

import com.lqc.zufang.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 通过用户名去数据库里查找对应用户
     * @param name 用户名
     * @return 用户信息
     */
    User getUserByName(String name);
}