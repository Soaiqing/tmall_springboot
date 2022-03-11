package com.wzh.tmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzh.tmall.dao.OrderDao;
import com.wzh.tmall.entity.Order;
import com.wzh.tmall.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * (Order)表服务实现类
 *
 * @author wzh
 * @since 2022-03-11 10:52:19
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

}

