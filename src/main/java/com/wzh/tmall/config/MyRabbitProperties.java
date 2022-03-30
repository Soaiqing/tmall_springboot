package com.wzh.tmall.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wzh
 * @date 2022-3-30 09:18:20
 * @Description 我的rabbit属性
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "rabbit")
public class MyRabbitProperties {
    private String queueWork;
    private String queueFanout1;
    private String queueFanout2;
    private String exchangeFanout;
    private String queueTopic1;
    private String queueTopic2;
    private String exchangeTopic;
    private String queueConfirm;
    private String queueReturn;
    private String exchangeReturn;
}
