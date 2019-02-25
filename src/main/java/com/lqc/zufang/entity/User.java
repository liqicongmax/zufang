package com.lqc.zufang.entity;

import lombok.Data;


public class User extends BaseEntity {
    private static final long serialVersionUID = -7982680044418363713L;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
