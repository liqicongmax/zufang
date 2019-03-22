package com.lqc.zufang.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;



/**
 * @author liqicong@myhexin.com
 * @date 2019/2/28 18:33
 */
@Component
public class Test {
    @Autowired
    RedisTemplate redisTemplate;
    public void set(){
        redisTemplate.opsForValue().set("xiaohong",123);
    }
    public static void main(String[] args){
        new Test().set();
    }
}
