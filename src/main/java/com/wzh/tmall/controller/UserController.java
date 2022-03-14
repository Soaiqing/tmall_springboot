package com.wzh.tmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzh.tmall.constant.RedisConstant;
import com.wzh.tmall.entity.User;
import com.wzh.tmall.service.UserService;
import com.wzh.tmall.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * (User)表控制层
 *
 * @author wzh
 * @since 2022-03-11 10:52:22
 */
@RestController
@RequestMapping("user")
@Api(value = "UserController" , tags = "(User)表控制层")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation(value = "分页查询所有数据")
    public R selectAll(Page<User> page, User user) {
        return success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation(value = "通过主键查询单条数据")
    public R<User> selectOne(@PathVariable Serializable id) {
        return success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping(value = "/insert")
    @ApiOperation(value = "新增数据")
    public R<Boolean> insert(@RequestBody User user) {
        return success(this.userService.save(user));
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping(value = "/update")
    @ApiOperation(value = "修改数据")
    public R<Boolean> update(@RequestBody User user) {
        return success(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation(value = "删除数据")
    public R<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userService.removeByIds(idList));
    }


    /**
     * 用户登录
     * @param user
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public R<String> login(@RequestBody User user) throws Exception {
        User userUser = userService.getOne(new QueryWrapper<User>()
        .lambda()
        .eq(User::getName,user.getName())
        .eq(User::getPassword,user.getPassword())
        .last("LIMIT 1"));
        if (userUser == null){
            throw new Exception("请输入正确的账号以及密码!");
        }else {
            //生成Token并存入缓存
            String token = JwtUtils.token(user.getName(),user.getPassword());
            redisTemplate.opsForValue().set(RedisConstant.USER_AUTHORIZATION + token,
                    userUser, RedisConstant.LOGIN_USER_TOKEN_TIMEOUT, TimeUnit.MINUTES);
            return R.ok(token);
        }
    }
}

