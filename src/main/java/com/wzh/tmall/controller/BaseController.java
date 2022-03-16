package com.wzh.tmall.controller;

import com.wzh.tmall.entity.User;
import com.wzh.tmall.service.UserService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author wzh
 * @date 2022-3-15 14:44:43
 * @description: Controller基类
 */
public abstract class BaseController {

    @Resource
    UserService userService;

    public User getUser(){
        //获取accessToken
        String accessToken = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getHeader("Authorization");
        if (accessToken == null) {
            return null;
        }
        return userService.getUserToken(accessToken);
    }
}
