package com.wzh.tmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzh.tmall.entity.Property;
import com.wzh.tmall.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Property)表控制层
 *
 * @author wzh
 * @since 2022-03-11 10:52:21
 */
@RestController
@RequestMapping("property")
public class PropertyController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PropertyService propertyService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param property 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Property> page, Property property) {
        return success(this.propertyService.page(page, new QueryWrapper<>(property)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.propertyService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param property 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Property property) {
        return success(this.propertyService.save(property));
    }

    /**
     * 修改数据
     *
     * @param property 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Property property) {
        return success(this.propertyService.updateById(property));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.propertyService.removeByIds(idList));
    }
}

