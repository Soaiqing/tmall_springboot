package com.wzh.tmall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Productimage)表实体类
 *
 * @author wzh
 * @since 2022-03-11 10:52:21
 */
@SuppressWarnings("serial")
@Data
public class Productimage extends Model<Productimage> {

    private Integer id;

    private Integer pid;

    private String type;



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

