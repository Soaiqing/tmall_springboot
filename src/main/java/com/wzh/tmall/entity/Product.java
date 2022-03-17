package com.wzh.tmall.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "(Product)表实体类")
@TableName("product")
public class Product extends Model<Product> {


    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "产品名")
    private String name;

    @ApiModelProperty(value = "产品小标题")
    private String subtitle;

    @ApiModelProperty(value = "原始价格")
    private Object originalprice;

    @ApiModelProperty(value = "优惠价格")
    private Object promoteprice;

    @ApiModelProperty(value = "存量")
    private Integer stock;

    @ApiModelProperty(value = "类别id")
    private Integer cid;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
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

