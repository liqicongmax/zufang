package com.lqc.zufang.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sun.awt.image.ImageAccessException;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/17 13:38
 */
@Aspect
@Component
public class ImageAspect {
    private Logger logger= LoggerFactory.getLogger(ImageAspect.class);

}
