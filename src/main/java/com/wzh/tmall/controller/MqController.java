package com.wzh.tmall.controller;

import com.wzh.tmall.service.MqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wzh
 * @date 2022-3-30 09:33:57
 * @deprecated MQ控制层
 */
@RestController
@RequestMapping("mq")
@Api(value = "MqController", tags = "MQ控制层")
public class MqController extends BaseController {
    @Resource
    private MqService mqService;

    @ApiOperation(value = "工作消息发送")
    @GetMapping("/workSend")
    public void workSend() {
        mqService.sendWork();
    }

    @ApiOperation(value = "出版消息发送")
    @GetMapping("/publishSend")
    public void publishSend() {
        mqService.sendPublic();
    }

    @ApiOperation(value = "主题消息发送")
    @GetMapping("/topicSend")
    public void topicSend() {
        mqService.sendTopic();
    }

    @ApiOperation(value = "Config消息发送")
    @GetMapping("/configSend")
    public void configSend() {
        mqService.sendConfirm();
    }

    @ApiOperation(value = "Return消息发送")
    @GetMapping("/sendReturn")
    public void sendReturn() {
        mqService.sendReturn();
    }


}
