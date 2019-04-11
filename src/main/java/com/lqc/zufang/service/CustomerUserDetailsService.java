package com.lqc.zufang.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/11 10:54
 */
public interface CustomerUserDetailsService {
    public UserDetails loadUserByUserId(Integer id)throws UsernameNotFoundException;
}
