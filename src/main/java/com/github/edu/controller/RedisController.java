package com.github.edu.controller;

import com.github.edu.base.controller.APIResponse;
import com.github.edu.base.controller.BaseController;
import com.github.edu.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：liming
 * @date ：2019/7/18 18:16
 * @description：
 */
@RestController
@RequestMapping("/redis/")
public class RedisController extends BaseController {

    @Autowired
    private RedisService redisService;


    @GetMapping("test")
    public APIResponse redisTest() {
        String s = (String) redisService.get("lisi");
        System.out.println("s==" + s);
        return success(s);
    }

    @GetMapping("set")
    public APIResponse setRedisStr() {
        redisService.set("lisi", "lisi123456");
        return success(true);
    }


}
