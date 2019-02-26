package com.lqc.zufang.service.impl;

import com.lqc.zufang.entity.User;
import com.lqc.zufang.mapper.UserMapper;
import com.lqc.zufang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean getUser(User user) {
        User user1=userMapper.getUserByName(user.getUsername());
        if(user1==null){
            return false;
        }
        String md5code=DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        System.out.println(md5code);
        return md5code.equals(user1.getPassword());
    }

    @Override
    public void insert(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.insert(user);
    }
}
