package com.wzh.tmall.listener;

import com.wzh.tmall.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author wzh
 * @date 2022-3-30 10:09:59
 * @Description "mq消息接受"
 */
@Component
@Log4j2
public class ConfirmReceiveListener {
    @RabbitListener(queues = "queue_confirm")
    public void receiveMsg(User user) {
        log.info("接收到的消息为：" + user);
    }
}


