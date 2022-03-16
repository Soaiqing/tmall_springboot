package com.wzh.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzh.tmall.entity.User;

/**
 * (User)表服务接口
 *
 * @author wzh
 * @since 2022-03-11 10:52:22
 */
public interface UserService extends IService<User> {

    /**
     * 获取当前登录的用户信息
     * @param token
     * @return
     */
    User getUserToken(String token);
}

