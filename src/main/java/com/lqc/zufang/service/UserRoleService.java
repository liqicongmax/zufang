package com.lqc.zufang.service;

import com.lqc.zufang.entity.UserRole;

import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/11 10:40
 */
public interface UserRoleService {
    List<UserRole> listByUserId(Integer id);
}
