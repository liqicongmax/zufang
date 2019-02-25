package com.lqc.zufang.entity;

import com.lqc.zufang.base.BaseDto;


public class User extends BaseDto {
    private static final long serialVersionUID = -7982680044418363713L;

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

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
