package com.wzh.tmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzh.tmall.dao.PropertyDao;
import com.wzh.tmall.entity.Property;
import com.wzh.tmall.service.PropertyService;
import org.springframework.stereotype.Service;

/**
 * (Property)表服务实现类
 *
 * @author wzh
 * @since 2022-03-11 10:52:21
 */
@Service
public class PropertyServiceImpl extends ServiceImpl<PropertyDao, Property> implements PropertyService {

}

