package com.wzh.tmall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author wzh
 * @since 2022-03-11 10:52:22
 */
@SuppressWarnings("serial")
@Data
@ApiModel(value = "(User)表实体类")
public class User extends Model<User> {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;


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

