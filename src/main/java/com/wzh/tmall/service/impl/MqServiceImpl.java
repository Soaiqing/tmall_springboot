package com.wzh.tmall.service.impl;


import com.wzh.tmall.config.MyRabbitProperties;
import com.wzh.tmall.entity.User;
import com.wzh.tmall.service.MqService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Mq服务实现类
 *
 * @author wzh
 * @since 2022-03-11 10:52:19
 */
@Service
public class MqServiceImpl implements MqService {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private MyRabbitProperties myRabbitProperties;

    @Override
    public void sendWork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(myRabbitProperties.getQueueWork(), "测试work模型: " + i);
        }

    }

    @Override
    public void sendPublic() {
        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend(myRabbitProperties.getExchangeFanout(), "", "测试发布订阅模型：" + i);
        }
    }

    @Override
    public void sendTopic() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                rabbitTemplate.convertSendAndReceive(myRabbitProperties.getExchangeTopic(), "topic.km.topic", "测试发布订阅模型：" + i);
            } else {
                rabbitTemplate.convertSendAndReceive(myRabbitProperties.getExchangeTopic(), "topic.km", "测试发布订阅模型：" + i);
            }
        }
    }

    @Override
    public void sendConfirm() {
        rabbitTemplate.convertAndSend(myRabbitProperties.getQueueConfirm(), new User(10, "wzh", "123456"), new CorrelationData("" + System.currentTimeMillis()));
        rabbitTemplate.setConfirmCallback(confirmCallback);
    }


    /**
     * 配置 confirm 机制
     */
    private final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        /**
         * @param correlationData 消息相关的数据，一般用于获取 唯一标识 id
         * @param b true 消息确认成功，false 失败
         * @param s 确认失败的原因
         */
        @Override
        public void confirm(CorrelationData correlationData, boolean b, String s) {
            if (b) {
                System.out.println("confirm 消息确认成功..." + correlationData.getId());
            } else {
                System.out.println("confirm 消息确认失败..." + correlationData.getId() + " cause: " + s);
            }
        }
    };


    // 配置 return 消息机制
    private final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        /**
         *  return 的回调方法（找不到路由才会触发）
         * @param message 消息的相关信息
         * @param i 错误状态码
         * @param s 错误状态码对应的文本信息
         * @param s1 交换机的名字
         * @param s2 路由的key
         */
        @Override
        public void returnedMessage(Message message, int i, String s, String s1, String s2) {
            System.out.println(message);
            System.out.println(new String(message.getBody()));
            System.out.println(i);
            System.out.println(s);
            System.out.println(s1);
            System.out.println(s2);
        }
    };

    // 测试return机制
    @Override
    public void sendReturn() {
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.convertAndSend(myRabbitProperties.getExchangeReturn(), "return.km.km", "测试 return 机制");
    }

}

