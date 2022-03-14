package com.wzh.tmall.aop;


import com.wzh.tmall.constant.RedisConstant;
import com.wzh.tmall.entity.User;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.security.auth.message.AuthException;


/**
 * @author wzh
 * @date 2022-3-11 15:21:30
 */
@Aspect
@Component
public class AuthCheckAspect implements HandlerInterceptor {


    @Resource
    RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.wzh.tmall.annotation.AuthCheck)")
    public void methodAspect() {
    }

    @Around("methodAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String authorization = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
        if (StringUtils.isBlank(authorization)){
            throw new AuthException("未登录");
        }
        User user = (User) redisTemplate.opsForValue().get(RedisConstant.USER_AUTHORIZATION + authorization);
        if (user == null){
            throw new AuthException("登录信息已失效");
        }
        return joinPoint.proceed();

    }
}
