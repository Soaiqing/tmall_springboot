package com.wzh.tmall.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Review)表实体类
 *
 * @author wzh
 * @since 2022-03-11 10:52:22
 */
@SuppressWarnings("serial")
@Data
public class Review extends Model<Review> {

    private Integer id;

    private String content;

    private Integer uid;

    private Integer pid;

    private Date createdate;



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

