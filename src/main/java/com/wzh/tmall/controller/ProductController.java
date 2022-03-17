package com.wzh.tmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzh.tmall.annotation.AuthCheck;
import com.wzh.tmall.entity.Product;
import com.wzh.tmall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Product)表控制层
 *
 * @author wzh
 * @since 2022-03-11 10:52:20
 */
@RestController
@RequestMapping("product")
@Api(value = "ProductController" , tags = "(Product)表控制层" )
public class ProductController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param product 查询实体
     * @return 所有数据
     */
    @GetMapping("/selectAll")
    @AuthCheck
    @ApiOperation(value = "分页查询所有数据")
    public R selectAll(Page<Product> page, Product product) {
        return R.ok(this.productService.page(page, new QueryWrapper<>(product)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @AuthCheck
    @GetMapping("/selectOne")
    public R selectOne(@RequestParam Serializable id) {
        return R.ok(this.productService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param product 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    @AuthCheck
    public R insert(@RequestBody Product product) {
        return R.ok(this.productService.save(product));
    }

    /**
     * 修改数据
     *
     * @param product 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Product product) {
        return R.ok(this.productService.updateById(product));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.productService.removeByIds(idList));
    }
}

