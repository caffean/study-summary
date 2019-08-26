package com.example.nettydemo.constant;

/**
 * @Classname RabbitMQExchangeConstant
 * @Description TODO
 * @Date 2019/8/23 14:10
 * @Author lyn
 */
public class RabbitMQConstant {

    /**
     * 以fanout方法发送A信息的Exchange名称
     */
    public static final String A_FANOUT_EXCHANGE = "AFanoutExchange";

    /**
     * 指定绑定到 AFanoutExchange 交换机的队列名称，用于接收 A 类型的信息
     */
    public static final String A_FANOUT_QUEUE = "AFanoutQueue";

    /**
     * 以direct方法发送A信息的Exchange名称
     */
    public static final String A_DIRECT_EXCHANGE = "ADirectExchange";

    /**
     * 指定绑定到 ADirectExchange 交换机的队列名称，用于接收 A 类型的信息
     */
    public static final String A_DIRECT_QUEUE = "ADirectQueue";


    /**
     * 指定路由key 为 A.rk1， 表示接收路由key为 A.rk1 的消息
     */
    public static final String A_RK1 = "A.rk1";

    /**
     * 以topic方法发送A信息的Exchange名称
     */
    public static final String A_TOPIC_EXCHANGE = "ATopicExchange";

    /**
     * 指定绑定到 ATopicExchange 交换机的队列名称，用于接收 A 类型的信息
     */
    public static final String A_TOPIC_QUEUE = "A_TopicQueue";

    /**
     * 指定路由key 为 A.#， 表示接收路由key为 A. 开头的消息
     */
    public static final String A_ALL = "A.#";
}
