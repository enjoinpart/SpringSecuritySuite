package com.github.edu.config.rabbitmq;

import com.github.edu.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author ：liming
 * @date ：2019/7/22 15:06
 * @description：
 */
@Service
@Slf4j
public class MQSender {



    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     * direct模式
     * @param message
     */
    public  void send(Object message){
        String msg=RedisService.beanToString(message);
        log.info("send msg=="+msg);
        amqpTemplate.convertAndSend(MQConfig.QUEUE,msg);
    }


    /**
     * topic模式
     * @param message
     */
    public void sendTopic(Object message){
        String msg = RedisService.beanToString(message);
        log.info("send topic message:"+msg);
        amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key1", msg+"1");
        amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key2", msg+"2");
    }


	public void sendFanout(Object message) {
		String msg = RedisService.beanToString(message);
		log.info("send fanout message:"+msg);
		amqpTemplate.convertAndSend(MQConfig.FANOUT_EXCHANGE, "", msg);
	}











}
