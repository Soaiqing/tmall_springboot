package com.wzh.tmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzh.tmall.dao.UserDao;
import com.wzh.tmall.entity.User;
import com.wzh.tmall.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author wzh
 * @since 2022-03-11 10:52:23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

