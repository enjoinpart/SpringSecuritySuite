package com.github.edu.config.rabbitmq;

import com.github.edu.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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

    public  void send(Object message){
        String msg=RedisService.beanToString(message);
        log.info("send msg=="+msg);
        amqpTemplate.convertAndSend(MQConfig.QUEUE,msg);

    }

}
