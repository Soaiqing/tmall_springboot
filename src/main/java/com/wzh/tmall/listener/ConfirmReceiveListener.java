package com.wzh.tmall.listener;

import com.wzh.tmall.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author wzh
 * @date 2022-3-30 10:09:59
 * @Description "mq消息接受"
 */
@Component
public class ConfirmReceiveListener {
    @RabbitListener(queues = "queue_confirm")
    public void receiveMsg(User user) {
        System.out.println("接收到的消息为：" + user);
    }
}


