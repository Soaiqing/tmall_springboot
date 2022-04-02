package com.wzh.tmall.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    @Bean
    public Queue queueTTL() {
        Map<String, Object> map = new HashMap(1);
        map.put("x-message-ttl", 10000);
        return new Queue(myRabbitProperties.getQueueTTL(), true, false, false, map);
    }

    @Bean
    public DirectExchange exchangeTTL() {
        return new DirectExchange(myRabbitProperties.getExchangeTTL());
    }

    @Bean
    public Binding bindingTTL() {
        return BindingBuilder.bind(queueTTL()).to(exchangeTTL()).with("receive_key");
    }

    @Bean
    public Queue queueDLX() {
        Map<String, Object> map = new HashMap(2);
        // 5秒后，消息自动变为死信
        map.put("x-message-ttl", 5000);
        map.put("x-dead-letter-exchange", "exchange_receive");
        map.put("x-dead-letter-routing-key", "receive_key");
        return new Queue(myRabbitProperties.getQueueDLX(), true, false, false, map);

    }


    @Bean
    public DirectExchange exchangeDLX() {
        return new DirectExchange(myRabbitProperties.getExchangeDLX());
    }

    @Bean
    public Binding bindingDLX() {
        return BindingBuilder.bind(queueDLX()).to(exchangeDLX()).with("receive_key");
    }

    // 死信接收交换机
    @Bean
    public DirectExchange exchangeReceive() {
        return new DirectExchange(myRabbitProperties.getExchangeReceive());
    }

    // 接收死信的队列
    @Bean
    public Queue queueReceive() {
        return new Queue(myRabbitProperties.getQueueReceive());
    }

    // 将交换机与队列绑定
    @Bean
    public Binding bindingReceive() {
        return BindingBuilder.bind(queueReceive()).to(exchangeReceive()).with("receive_key");
    }


}
