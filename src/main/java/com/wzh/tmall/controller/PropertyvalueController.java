package com.wzh.tmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzh.tmall.entity.Propertyvalue;
import com.wzh.tmall.service.PropertyvalueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Propertyvalue)表控制层
 *
 * @author wzh
 * @since 2022-03-11 10:52:21
 */
@RestController
@RequestMapping("propertyvalue")
public class PropertyvalueController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PropertyvalueService propertyvalueService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param propertyvalue 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Propertyvalue> page, Propertyvalue propertyvalue) {
        return success(this.propertyvalueService.page(page, new QueryWrapper<>(propertyvalue)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.propertyvalueService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param propertyvalue 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Propertyvalue propertyvalue) {
        return success(this.propertyvalueService.save(propertyvalue));
    }

    /**
     * 修改数据
     *
     * @param propertyvalue 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Propertyvalue propertyvalue) {
        return success(this.propertyvalueService.updateById(propertyvalue));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.propertyvalueService.removeByIds(idList));
    }
}

