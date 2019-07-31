package com.github.edu.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author ：liming
 * @date ：2019/7/22 15:04
 * @description：
 */
@Configuration
public class MQConfig {

    public static final String QUEUE = "queue";

    public static final String TOPIC_QUEUE1 = "topic.queu1";
    public static final String TOPIC_QUEUE2 = "topic.queu2";
    public static final String TOPIC_EXCHANGE = "topicExchage";

    public static final String FANOUT_EXCHANGE = "fanoutxchage";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1, true);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2, true);
    }


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }


    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.key1");
    }
    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.key#");
    }


    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }


    @Bean
    public Binding fanoutBinding1(){
        return  BindingBuilder.bind(topicQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinding2(){
        return  BindingBuilder.bind(topicQueue2()).to(fanoutExchange());
    }



}
