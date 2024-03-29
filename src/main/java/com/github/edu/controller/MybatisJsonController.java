package com.github.edu.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.edu.base.controller.APIResponse;
import com.github.edu.base.controller.BaseController;
import com.github.edu.entity.MybatisJson;
import com.github.edu.service.MybatisJsonService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ：liming
 * @date ：2019/7/18 14:54
 * @description：
 */
@RestController
@RequestMapping("/json/")
public class MybatisJsonController extends BaseController {

    private MybatisJsonService mybatisJsonService;


    @Autowired
    public MybatisJsonController(MybatisJsonService mybatisJsonService) {
        this.mybatisJsonService = mybatisJsonService;
    }

    @GetMapping("getJson/{id}")
    public APIResponse getJson(@PathVariable  Long id){
       MybatisJson mybatisJson= mybatisJsonService.getJson(id);
        JSONObject jsonInfo = mybatisJson.getInfo();
        String address = jsonInfo.getString("address");
       return  success(ImmutableMap.of("jsonInfo",jsonInfo,"address",address));
    }

}
