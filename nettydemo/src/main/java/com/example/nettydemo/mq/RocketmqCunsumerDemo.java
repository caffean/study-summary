package com.example.nettydemo.mq;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Classname RocketmqCunsumerDemo
 * @Description TODO
 * @Date 2019/8/26 9:36
 * @Author lyn
 */
@Component
@RocketMQMessageListener(topic = "${contract-customer.topic}", consumerGroup = "${contract-customer.consumerGroup}")
public class RocketmqCunsumerDemo implements RocketMQListener<MessageExt> {


    @Override
    public void onMessage(MessageExt messageExt) {
        System.out.println("i am rocketmq message " + new String(messageExt.getBody()) +"tags: "+ messageExt.getTags() +" date:"+ LocalDateTime.now());
    }
}
