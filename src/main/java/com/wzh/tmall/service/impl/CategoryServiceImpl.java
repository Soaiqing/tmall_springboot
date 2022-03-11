package com.wzh.tmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzh.tmall.dao.CategoryDao;
import com.wzh.tmall.entity.Category;
import com.wzh.tmall.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * (Category)表服务实现类
 *
 * @author wzh
 * @since 2022-03-11 10:52:19
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

}

