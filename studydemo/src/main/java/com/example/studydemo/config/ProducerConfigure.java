//package com.example.studydemo.config;
//
//import lombok.extern.log4j.Log4j;
//import lombok.extern.log4j.Log4j2;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Classname ProducerConfigure
// * @Description TODO
// * @Date 2019/8/23 17:07
// * @Author lyn
// */
//@Configuration
//@Log4j2
//public class ProducerConfigure {
//
//    @Autowired
//    private RocketProducerConfig producerConfigure;
//
//    /**
//     * 创建普通消息发送者实例
//     *
//     * @return
//     * @throws MQClientException
//     */
//    @Bean
//    @ConditionalOnProperty(prefix = "rocketmq.producer", value = "default", havingValue = "true")
//    public DefaultMQProducer defaultProducer() throws MQClientException {
//        log.info(producerConfigure.toString());
//        log.info("defaultProducer 正在创建---------------------------------------");
//        DefaultMQProducer producer = new DefaultMQProducer(producerConfigure.getGroupName());
//        producer.setNamesrvAddr(producerConfigure.getNamesrvAddr());
//        producer.setVipChannelEnabled(false);
//        producer.setRetryTimesWhenSendAsyncFailed(10);
//        producer.start();
//        log.info("rocketmq producer server开启成功---------------------------------.");
//        return producer;
//    }
//}
