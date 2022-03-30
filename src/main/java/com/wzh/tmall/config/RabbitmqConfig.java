package com.wzh.tmall.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RabbitmqConfig {
    @Resource
    MyRabbitProperties myRabbitProperties;

    @Bean
    public Queue queueWork() {
        return new Queue(myRabbitProperties.getQueueWork());
    }

    @Bean
    public Queue queueFanout1() {
        return new Queue(myRabbitProperties.getQueueFanout1());
    }

    @Bean
    public Queue queueFanout2() {
        return new Queue(myRabbitProperties.getQueueFanout2());
    }

    /**
     * 交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(myRabbitProperties.getExchangeFanout());
    }

    /**
     * 交换机和队列进行绑定
     *
     * @return
     */
    @Bean
    public Binding bindingExchange1() {
        return BindingBuilder.bind(queueFanout1()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchange2() {
        return BindingBuilder.bind(queueFanout2()).to(fanoutExchange());
    }

    @Bean
    public Queue queueTopic1() {
        return new Queue(myRabbitProperties.getQueueTopic1());
    }

    @Bean
    public Queue queueTopic2() {
        return new Queue(myRabbitProperties.getQueueTopic2());
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(myRabbitProperties.getExchangeTopic());
    }

    @Bean
    public Binding bindingTopic1() {
        return BindingBuilder.bind(queueTopic1()).to(topicExchange()).with("topic.#");
    }

    @Bean
    public Binding bindingTopic2() {
        return BindingBuilder.bind(queueTopic2()).to(topicExchange()).with("topic.*");
    }


    // 测试confirm机制
    @Bean
    public Queue queueConfirm() {
        return new Queue(myRabbitProperties.getQueueConfirm());
    }

    // 测试return机制
    @Bean
    public Queue queueReturn() {
        return new Queue(myRabbitProperties.getQueueReturn());
    }

    @Bean
    public TopicExchange exchangeReturn() {
        return new TopicExchange(myRabbitProperties.getExchangeReturn());
    }

    @Bean
    public Binding bindingReturn() {
        return BindingBuilder.bind(queueReturn()).to(exchangeReturn()).with("return.*");
    }


}
