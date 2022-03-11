package com.wzh.tmall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Category)表实体类
 *
 * @author wzh
 * @since 2022-03-11 10:52:19
 */
@SuppressWarnings("serial")
@Data
public class Category extends Model<Category> {

    private Integer id;

    private String name;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

