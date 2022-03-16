package com.wzh.tmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzh.tmall.constant.RedisConstant;
import com.wzh.tmall.dao.UserDao;
import com.wzh.tmall.entity.User;
import com.wzh.tmall.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author wzh
 * @since 2022-03-11 10:52:23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {


    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public User getUserToken(String token) {
        User user = (User) redisTemplate.opsForValue().get(RedisConstant.USER_AUTHORIZATION + token);
        return user;
    }
}

