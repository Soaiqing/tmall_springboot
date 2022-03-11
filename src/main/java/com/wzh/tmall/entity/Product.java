package com.wzh.tmall.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Product)表实体类
 *
 * @author wzh
 * @since 2022-03-11 10:52:20
 */
@SuppressWarnings("serial")
public class Product extends Model<Product> {

    private Integer id;

    private String name;

    private String subtitle;

    private Object originalprice;

    private Object promoteprice;

    private Integer stock;

    private Integer cid;

    private Date createdate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Object getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(Object originalprice) {
        this.originalprice = originalprice;
    }

    public Object getPromoteprice() {
        return promoteprice;
    }

    public void setPromoteprice(Object promoteprice) {
        this.promoteprice = promoteprice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

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

