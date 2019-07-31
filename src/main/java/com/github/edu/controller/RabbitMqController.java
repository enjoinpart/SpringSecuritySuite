package com.github.edu.controller;

import com.github.edu.config.rabbitmq.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：liming
 * @date ：2019/7/22 17:59
 * @description：
 */
@RestController
public class RabbitMqController {


    @Autowired
    private MQSender mqSender;

    @RequestMapping("/send")
    public void send(){
        System.out.println("==========123");
        mqSender.send("发送信息");
    }

    @RequestMapping("/sendTopic")
    public void sendTopic(){
        mqSender.sendTopic("topic 发送消息");
    }

    @RequestMapping("/sendFanout")
    public void sendFanout(){
        mqSender.sendFanout("topic sendFanout 发送消息");
    }

}
