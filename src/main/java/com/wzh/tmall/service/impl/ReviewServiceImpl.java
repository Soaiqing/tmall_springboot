package com.wzh.tmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzh.tmall.dao.ReviewDao;
import com.wzh.tmall.entity.Review;
import com.wzh.tmall.service.ReviewService;
import org.springframework.stereotype.Service;

/**
 * (Review)表服务实现类
 *
 * @author wzh
 * @since 2022-03-11 10:52:22
 */
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewDao, Review> implements ReviewService {

}

