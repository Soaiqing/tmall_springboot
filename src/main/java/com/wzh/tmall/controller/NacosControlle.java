package com.wzh.tmall.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试nacos配置中心
 * @author wzh
 * @date 2022-4-6 16:16:37
 */

@RestController
@Controller("NacosControlle")
public class NacosControlle {


    @Value("${spring.datasource.username:}")
    private String username;

    @Value("${spring.datasource.password:}")
    private String password;
    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("test")
    public R test() {
        System.out.println(username + password);
        return R.ok(username + password);
    }
}
