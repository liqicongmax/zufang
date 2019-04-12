package com.lqc.zufang.aspect;

import com.lqc.zufang.entity.Data;
import com.lqc.zufang.entity.Ip2Address;
import com.lqc.zufang.util.RedisUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2019/4/12 16:15
 */
@Aspect
@Component
public class AddressAspect {
    @Autowired
    RedisUtil redisUtil;
    private Logger logger = LoggerFactory.getLogger(AddressAspect.class);

    /**
     * 定义切入点,所有控制器执行的方法都是切点
     */
    @Pointcut("execution(public * com.lqc.zufang.controller.*.*(..))")
    public void getAddress() {
    }

    /**
     * 定义在切点之前执行的方法
     */
    @Before("getAddress()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Data address=(Data) session.getAttribute("address");
        if(address==null){
            String ip = "101.71.41.228";
            //ip="125.114.238.231";
            Ip2Address ip2Address =(Ip2Address)redisUtil.get(ip);
            Data data=ip2Address.getData();
            session.setAttribute("address",data);
        }
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 定义方法返回之后执行的内容
     *
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "getAddress()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
