package com.lqc.zufang.service;

/**
 * @author liqicong@myhexin.com
 * @date 2019/3/22 11:22
 */
public interface RedisService {
    void set(String key,Object object,long expire);
    void set(String key,Object object);
    Object get(String key);

}
