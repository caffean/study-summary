package com.example.nettydemo.mq;

import com.example.nettydemo.constant.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname RabbitmqConsumerDemo
 * @Description 用于接收A消息的消费者consumer
 * @Date 2019/8/23 14:19
 * @Author lyn
 */
//@Component
//表示监听名称为 AFanoutQueue 的消息队列
//@RabbitListener(queues = {RabbitMQConstant.A_FANOUT_QUEUE})
public class RabbitmqConsumerDemo {

    /**
     * 定义接收消息处理逻辑
     * @param content
     */
    @RabbitHandler
    public void handler(String content) {
        System.out.println("RabbitmqConsumerDemo 接收到消息: " + content);
    }

}
