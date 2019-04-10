package com.lqc.zufang.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;



/**
 * @author liqicong@myhexin.com
 * @date 2019/2/28 18:33
 */
@Component
public class Test {
    @Autowired
    RedisUtil redisUtil;
    public void test(){
        redisUtil.set("wo","asd");
    }

}
