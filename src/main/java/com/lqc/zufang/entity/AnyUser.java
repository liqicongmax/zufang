package com.lqc.zufang.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/18 17:23
 */
public class AnyUser extends User {
    private Long id;

    public AnyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
