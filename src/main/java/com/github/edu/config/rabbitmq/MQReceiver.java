package com.github.edu.config.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author ：liming
 * @date ：2019/7/22 17:54
 * @description：
 */
@Service
@Slf4j
public class MQReceiver {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void receive(String msg){
        log.info("receive msg=="+msg);

    }

}
