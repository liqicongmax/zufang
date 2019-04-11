package com.lqc.zufang.service.impl;

import com.lqc.zufang.entity.User;
import com.lqc.zufang.entity.UserRole;
import com.lqc.zufang.service.RoleService;
import com.lqc.zufang.service.UserRoleService;
import com.lqc.zufang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 通过自定义的数据库验证来给登录用户赋予权限
 *
 * @author liqicong@myhexin.com
 * @date 2019/4/11 10:55
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Integer userId = userService.getUserByUserName(username).getId().intValue();
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        User user = userService.getUserById(userId.longValue());
        UserRole userRole = userRoleService.listByUserId(userId);
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleService.selectById(userRole.getRoleId().intValue()).getName());
        authorities.add(simpleGrantedAuthority);
        System.out.println("我的权限-------------------" + simpleGrantedAuthority.getAuthority());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }


}
