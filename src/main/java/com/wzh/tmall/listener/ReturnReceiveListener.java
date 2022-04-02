package com.wzh.tmall.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author wzh
 * @date 2022-3-30 10:09:59
 * @Description "mq消息接受"
 */
@Component
public class ReturnReceiveListener {
    @RabbitListener(queues = "queue_return")
    public void receiveMsg(String msg) {
        System.out.println("接收的消息为：" + msg);
    }
}



