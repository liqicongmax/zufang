package com.lqc.zufang.service.impl;

import com.lqc.zufang.entity.User;
import com.lqc.zufang.entity.UserRole;
import com.lqc.zufang.service.RoleService;
import com.lqc.zufang.service.CustomerUserDetailsService;
import com.lqc.zufang.service.UserRoleService;
import com.lqc.zufang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/11 10:55
 */
@Service
public class CustomerUserDetailsServiceImpl implements CustomerUserDetailsService {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @Override
    public UserDetails loadUserByUserId(Integer id) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        User user=userService.getUserById(id.longValue());
        List<UserRole> list=userRoleService.listByUserId(id);
        for(UserRole userRole:list){
            authorities.add(new SimpleGrantedAuthority(roleService.selectById(userRole.getRoleId().intValue()).getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
