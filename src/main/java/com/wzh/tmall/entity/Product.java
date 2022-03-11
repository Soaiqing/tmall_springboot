package com.wzh.tmall.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Product)表实体类
 *
 * @author wzh
 * @since 2022-03-11 10:52:20
 */
@SuppressWarnings("serial")
@Data
public class Product extends Model<Product> {

    private Integer id;

    private String name;

    private String subtitle;

    private Object originalprice;

    private Object promoteprice;

    private Integer stock;

    private Integer cid;

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

