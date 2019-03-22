package com.lqc.zufang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class ZufangApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void set() {
        String xiaoming="xiaoming";
        redisTemplate.opsForValue().set("xiaohong",234);
        System.out.println(redisTemplate.opsForValue().get("xiaohong"));
        redisTemplate.opsForValue().set("xiaoming",222);
    }

}
