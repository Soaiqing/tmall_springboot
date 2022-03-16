package com.wzh.tmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzh.tmall.annotation.AuthCheck;
import com.wzh.tmall.entity.Category;
import com.wzh.tmall.entity.User;
import com.wzh.tmall.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Category)表控制层
 *
 * @author wzh
 * @since 2022-03-11 10:52:19
 */
@RestController
@RequestMapping("category")
@Api(value = "CategoryController" , tags = "(Category)表控制层" )
public class CategoryController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param category 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Category> page, Category category) {
        return R.ok(this.categoryService.page(page, new QueryWrapper<>(category)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "查询商品类别")
    @GetMapping("/selectOne")
    @AuthCheck
    public R selectOne(@RequestParam Serializable id) {
        User user = getUser();
        System.out.println(user);
        return R.ok(this.categoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param category 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Category category) {
        return R.ok(this.categoryService.save(category));
    }

    /**
     * 修改数据
     *
     * @param category 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Category category) {
        return R.ok(this.categoryService.updateById(category));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.categoryService.removeByIds(idList));
    }
}

