package com.example.nettydemo.config;

import com.example.nettydemo.constant.RabbitMQConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname RabbitMQExchangeConfig
 * @Description TODO
 * @Date 2019/8/23 14:13
 * @Author lyn
 */
@Configuration
public class RabbitMQConfig {

    /**
     * 以Fanout方式发送消息
     * 定义一个Exchange交换机，从该交换机接收消息
     * @return
     */
    //@Bean
    //public FanoutExchange AFanoutExchange() {
    //    //传入exchange交换机的名称 AFanoutExchange
    //    return new FanoutExchange(RabbitMQConstant.A_FANOUT_EXCHANGE);
    //}

    /**
     * 创建绑定到 AFanoutExchange 交换机的队列
     * @return
     */
    //@Bean
    //public Queue AFanoutQueue() {
    //    //传入队列名称
    //    return new Queue(RabbitMQConstant.A_FANOUT_QUEUE);
    //}


    ///**
    // * 将 AFanoutQueue 队列绑定到 AFanoutExchange 交换机上
    // * 用 AFanoutQueue 队列接收 AFanoutExchange 发送过来的消息
    // * @param AFanoutQueue
    // * @param AFanoutExchange
    // * @return
    // */
    //@Bean
    //public Binding bindAFanoutExchangeToAFanoutQueue(Queue AFanoutQueue, FanoutExchange AFanoutExchange) {
    //    return BindingBuilder.bind(AFanoutQueue).to(AFanoutExchange);
    //}

    /**
     * 以direct方式发送消息
     * 定义一个Exchange交换机，从该交换机接收消息
     * @return
     */
    //@Bean
    //public DirectExchange ADirectExchange() {
    //    //传入exchange交换机的名称 ADirectExchange
    //    return new DirectExchange(RabbitMQConstant.A_DIRECT_EXCHANGE);
    //}

    /**
     * 创建绑定到 ADirectExchange 交换机的队列
     * @return
     */
    //@Bean
    //public Queue ADirectQueue() {
    //    //传入队列名称
    //    return new Queue(RabbitMQConstant.A_DIRECT_QUEUE);
    //}

    /**
     * 将 ADirectQueue 队列绑定到 ADirectExchange交换机上
     * 用 ADirectQueue 队列接收 ADirectExchange 交换机发送过来的消息
     * 指定路由key 为 A.rk1
     * @param ADirectQueue
     * @param ADirectExchange
     * @return
     */
    //@Bean
    //public Binding bindADirectExchangeToADirectQueue(Queue ADirectQueue, DirectExchange ADirectExchange) {
    //    //以 direct 方式接收消息需要指定路由key，也就是with传入的参数
    //    return BindingBuilder.bind(ADirectQueue).to(ADirectExchange).with(RabbitMQConstant.A_RK1);
    //}

    /**
     * 以topic方式发送消息
     * 定义一个Exchange交换机，发送的消息将通过该交换机转发
     * @return
     */
    @Bean
    public TopicExchange ATopicExchange() {
        //传入exchange交换机的名称 ATopicExchange
        return new TopicExchange(RabbitMQConstant.A_TOPIC_EXCHANGE);
    }

    /**
     * 创建绑定到 ATopicExchange 交换机的队列
     *
     * @return
     */
    @Bean
    public Queue ATopicQueue() {
        //传入队列名称
        return new Queue(RabbitMQConstant.A_TOPIC_QUEUE);
    }


    /**
     * 将 ATopicQueue 队列绑定到 ATopicExchange
     * 用 ATopicQueue 队列接收 ATopicExchange 交换机发送过来的消息
     * 指定路由key 为 A.#
     * @param ATopicQueue
     * @param ATopicExchange
     * @return
     */
    @Bean
    public Binding bindATopicExchangeToA_BTopicQueue(Queue ATopicQueue, TopicExchange ATopicExchange) {
        //以 direct 方式接收消息需要指定路由key，也就是with传入的参数
        return BindingBuilder.bind(ATopicQueue).to(ATopicExchange).with(RabbitMQConstant.A_ALL);
    }

}
