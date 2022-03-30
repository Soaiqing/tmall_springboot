package com.wzh.tmall.service;


/**
 * (Category)表服务接口
 *
 * @author wzh
 * @since 2022-03-11 10:52:19
 */
public interface MqService {
    /**
     * 发送工作
     */
    void sendWork();

    /**
     * 发布
     */
    void sendPublic();

    /**
     * 主题
     */
    void sendTopic();


    /**
     * Confirm
     */
    void sendConfirm();


    /**
     * Return
     */
    void sendReturn();
}

