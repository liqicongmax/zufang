package com.lqc.zufang.service.impl;

import com.lqc.zufang.entity.Role;
import com.lqc.zufang.mapper.RoleMapper;
import com.lqc.zufang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/11 10:38
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public Role selectById(Integer id) {
        return roleMapper.selectById(id);
    }
}
