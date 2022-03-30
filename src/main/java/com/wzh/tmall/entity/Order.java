package com.wzh.tmall.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "(Order)表实体类")
@TableName("order")
public class Order extends Model<Order> implements Serializable{

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = " 订单号")
    private String orderCode;

    @ApiModelProperty(value = "收货地址")
    private String address;

    @ApiModelProperty(value = "邮编")
    private String post;

    @ApiModelProperty(value = "收货人信息")
    private String receiver;

    @ApiModelProperty(value = " 手机号码")
    private String mobile;

    @ApiModelProperty(value = "用户备注信息")
    private String userMessage;

    @ApiModelProperty(value = "订单创建日期")
    private Date createdate;

    @ApiModelProperty(value = "支付日期")
    private Date paydate;

    @ApiModelProperty(value = "发货日期")
    private Date deliverydate;

    @ApiModelProperty(value = "确认收货日期")
    private Date confirmdate;

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "订单状态")
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

