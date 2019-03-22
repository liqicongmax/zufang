package com.lqc.zufang.service.impl;

import com.lqc.zufang.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/22 13:21
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 创建键值对信息并设置过期时间
     * @param key
     * @param object
     * @param expire
     */
    @Override
    public void set(final String key, Object object, long expire) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, object, expire, TimeUnit.SECONDS);
    }

    @Override
    public void set(final String key, Object object) {
        ValueOperations<Serializable,Object> operations=redisTemplate.opsForValue();
        operations.set(key,object);
    }

    @Override
    public Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }
}

