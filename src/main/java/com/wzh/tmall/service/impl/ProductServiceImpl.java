package com.wzh.tmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzh.tmall.dao.ProductDao;
import com.wzh.tmall.entity.Product;
import com.wzh.tmall.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * (Product)表服务实现类
 *
 * @author wzh
 * @since 2022-03-11 10:52:20
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {

}

