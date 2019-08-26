package com.example.studydemo;

/**
 * @Classname RabbitmqTest
 * @Description TODO
 * @Date 2019/8/23 14:21
 * @Author lyn
 */

import com.example.studydemo.mq.RabbitMqProducerDemo;
import com.example.studydemo.mq.RocketmqProducerDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ASender的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTest {

    @Autowired
    private RabbitMqProducerDemo rabbitMqProducerDemo;
    @Autowired
    private RocketmqProducerDemo rocketmqProducerDemo;

    /**
     * 以 Fanout 方式发送消息测试用例
     */
    @Test
    public void sendToAFanoutExchangeTest() {
        String msg = "Hello, I am A msg. — sendToAFanoutExchange";
        this.rabbitMqProducerDemo.sendToAFanoutExchange(msg);
    }

    /**
     * 以 Direct 方式发送消息测试用例
     */
    @Test
    public void sendToADirectExchangeTest() {
        String msg = "Hello, I am A msg. — sendToADirectExchange ";
        //第一个参数为送的消息
        //第二个参数为发送消息的路由key
        this.rabbitMqProducerDemo.sendToADirectExchange(msg, "A.rk1");
    }

    /**
     * 以 Topic 方式发送消息测试用例
     */
    @Test
    public void sendToATopicExchangeTest() {
        String msg = "Hello, I am A.b msg. — sendToATopicExchange ";
        //第一个参数为送的消息
        //第二个参数为发送消息的路由key
        this.rabbitMqProducerDemo.sendToATopicExchange(msg, "A.b");
    }

    @Test
    public void sendToRocketmqTest() {
        String msg = "rocketmq test ";
        //第一个参数为送的消息
        //第二个参数为发送消息的路由key
        this.rocketmqProducerDemo.send(msg);
    }
}
