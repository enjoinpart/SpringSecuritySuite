package com.github.edu.controller;

import com.github.edu.config.rabbitmq.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：liming
 * @date ：2019/7/22 17:59
 * @description：
 */
@Controller
public class RabbitMqController {


    @Autowired
    private MQSender mqSender;

    @RequestMapping("/send")
    public void send(){
        System.out.println("==========123");
        mqSender.send("发送信息");
    }

}
