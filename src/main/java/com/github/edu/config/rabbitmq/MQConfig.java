package com.github.edu.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author ：liming
 * @date ：2019/7/22 15:04
 * @description：
 */
@Configuration
public class MQConfig {

    public  static  final String QUEUE="queue";

    @Bean
    public Queue queue(){
        return  new Queue(QUEUE,true) ;
    }


}
