package com.github.edu.controller;

import com.github.edu.config.rabbitmq.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：liming
 * @date ：2019/7/22 12:59
 * @description：
 */
@Controller
public class LoginController {


    @Autowired
    private MQSender mqSender;

    @RequestMapping("/to_login")
    public  String toLogin(){
        mqSender.send("发送消息");
        System.out.println("----------------to_login--------------------");

        return  "login";
    }
}
