package com.lqc.zufang.service.impl;

import com.lqc.zufang.entity.UserRole;
import com.lqc.zufang.mapper.UserRoleMapper;
import com.lqc.zufang.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/11 10:42
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> listByUserId(Integer id) {
        return userRoleMapper.listByUserId(id);
    }
}
