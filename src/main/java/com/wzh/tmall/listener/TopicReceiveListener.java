package com.wzh.tmall.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author wzh
 * @date 2022-3-30 10:09:59
 * @deprecated "mq消息接受"
 */
@Component
public class TopicReceiveListener {
    @RabbitListener(queues = "queue_Topic1")
    public void receiveMsg1(String msg) {
        System.out.println("消费者1接收到：" + msg);
    }

    @RabbitListener(queues = "queue_Topic2")
    public void receiveMsg2(String msg) {
        System.out.println("消费者2接收到：" + msg);
    }

}
