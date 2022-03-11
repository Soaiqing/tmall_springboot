package com.wzh.tmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzh.tmall.entity.Review;
import com.wzh.tmall.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Review)表控制层
 *
 * @author wzh
 * @since 2022-03-11 10:52:22
 */
@RestController
@RequestMapping("review")
public class ReviewController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ReviewService reviewService;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param review 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Review> page, Review review) {
        return success(this.reviewService.page(page, new QueryWrapper<>(review)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.reviewService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param review 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Review review) {
        return success(this.reviewService.save(review));
    }

    /**
     * 修改数据
     *
     * @param review 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Review review) {
        return success(this.reviewService.updateById(review));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.reviewService.removeByIds(idList));
    }
}

