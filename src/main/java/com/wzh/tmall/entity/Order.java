package com.wzh.tmall.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Order)表实体类
 *
 * @author wzh
 * @since 2022-03-11 10:52:19
 */
@SuppressWarnings("serial")
@Data
public class Order extends Model<Order> {

    private Integer id;

    private String ordercode;

    private String address;

    private String post;

    private String receiver;

    private String mobile;

    private String usermessage;

    private Date createdate;

    private Date paydate;

    private Date deliverydate;

    private Date confirmdate;

    private Integer uid;

    private String status;



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

