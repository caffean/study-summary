package com.example.studydemo.constant;

/**
 * @Classname RabbitMQExchangeConstant
 * @Description TODO
 * @Date 2019/8/23 14:10
 * @Author lyn
 */
public class RabbitMQExchangeConstant {

    /**
     * 以fanout方法发送A信息的Exchange名称
     */
    public static final String A_FANOUT_EXCHANGE = "AFanoutExchange";

    /**
     * 以direct方法发送A信息的Exchange名称
     */
    public static final String A_DIRECT_EXCHANGE = "ADirectExchange";

    /**
     * 以topic方法发送A信息的Exchange名称
     */
    public static final String A_TOPIC_EXCHANGE = "ATopicExchange";
}
