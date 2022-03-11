package com.wzh.tmall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Orderitem)表实体类
 *
 * @author wzh
 * @since 2022-03-11 10:52:20
 */
@SuppressWarnings("serial")
@Data
public class Orderitem extends Model<Orderitem> {

    private Integer id;

    private Integer pid;

    private Integer oid;

    private Integer uid;

    private Integer number;


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

