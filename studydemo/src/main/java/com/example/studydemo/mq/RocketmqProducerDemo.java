package com.example.studydemo.mq;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Classname RocketmqProducerDemo
 * @Description TODO
 * @Date 2019/8/26 9:44
 * @Author lyn
 */
@Component
public class RocketmqProducerDemo {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void send(String message){
        //rocketMQTemplate.convertAndSend("topic_xxb_customer_test", "Hello, World!"+message);
        //rocketMQTemplate.send("topic_xxb_customer_test", MessageBuilder.withPayload("Hello, World! I'm from spring message: "+message).build());
        // 第三个参数为key
        //message1.setDelayTimeLevel(3);
        String msg = "Hello, World! I'm from simple message: " + message + "date：" + LocalDateTime.now() + " ";
        GenericMessage<String> message1 = new GenericMessage<>(msg);
        //message1.setBody(msg.getBytes());
        //可以设置延迟队列 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h level4 就是30s
        SendResult result = rocketMQTemplate.syncSend("topic_xxb_customer_test", message1, 1000L,4);

        // topic: topic_xxb_customer_test，tag: xxb, cacel
        //rocketMQTemplate.convertAndSend("topic_xxb_customer_test:xxb", "Hello, World!");
        //rocketMQTemplate.convertAndSend("ORDER:cancel", "Hello, World!");

        // 消息体为自定义对象
        //rocketMQTemplate.convertAndSend("topic_xxb_customer_test", new OrderPaidEvent("11",new BigDecimal(1.1)));


        // 发送延迟消息
        //rocketMQTemplate.sendDelayed("test-topic-1", "I'm delayed message", MessageDelayLevel.TIME_1M);

        // 发送即发即失消息（不关心发送结果）
        //rocketMQTemplate.sendOneWay("test-topic-1", MessageBuilder.withPayload("I'm one way message").build());


        // 发送顺序消息
        //rocketMQTemplate.syncSendOrderly("test-topic-4", "I'm order message", "1234");
        //System.out.println(result.toString());

    }
}
