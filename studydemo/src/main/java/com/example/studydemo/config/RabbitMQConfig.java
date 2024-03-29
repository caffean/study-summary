package com.example.studydemo.config;

import com.example.studydemo.constant.RabbitMQExchangeConstant;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname RabbitMQExchangeConfig
 * @Description TODO
 * @Date 2019/8/23 14:09
 * @Author lyn
 */
@Configuration
public class RabbitMQConfig {

    ///**
    // * 以Fanout方式发送消息
    // * 定义一个Exchange交换机，发送的消息将通过该交换机转发
    // * @return
    // */
    //@Bean
    //public FanoutExchange AFanoutExchange() {
    //    //传入exchange交换机的名称 AFanoutExchange
    //    return new FanoutExchange(RabbitMQExchangeConstant.A_FANOUT_EXCHANGE);
    //}


    /**
     * 以direct方式发送消息
     * 定义一个Exchange交换机，发送的消息将通过该交换机转发
     * @return
     */
    //@Bean
    //public DirectExchange ADirectExchange() {
    //    //传入exchange交换机的名称 ADirectExchange
    //    return new DirectExchange(RabbitMQExchangeConstant.A_DIRECT_EXCHANGE);
    //}


    /**
     * 以topic方式发送消息
     * 定义一个Exchange交换机，发送的消息将通过该交换机转发
     * @return
     */
    @Bean
    public TopicExchange ATopicExchange() {
        //传入exchange交换机的名称 ATopicExchange
        return new TopicExchange(RabbitMQExchangeConstant.A_TOPIC_EXCHANGE);
    }
}
