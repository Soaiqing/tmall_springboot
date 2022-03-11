package com.wzh.tmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzh.tmall.entity.Orderitem;
import com.wzh.tmall.service.OrderitemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Orderitem)表控制层
 *
 * @author wzh
 * @since 2022-03-11 10:52:20
 */
@RestController
@RequestMapping("orderitem")
public class OrderitemController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OrderitemService orderitemService;

    /**
     * 分页查询所有数据
     *
     * @param page      分页对象
     * @param orderitem 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Orderitem> page, Orderitem orderitem) {
        return success(this.orderitemService.page(page, new QueryWrapper<>(orderitem)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.orderitemService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param orderitem 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Orderitem orderitem) {
        return success(this.orderitemService.save(orderitem));
    }

    /**
     * 修改数据
     *
     * @param orderitem 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Orderitem orderitem) {
        return success(this.orderitemService.updateById(orderitem));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.orderitemService.removeByIds(idList));
    }
}

