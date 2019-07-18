package com.github.edu.controller;

import com.github.edu.base.controller.APIResponse;
import com.github.edu.base.controller.BaseController;
import com.github.edu.entity.MybatisJson;
import com.github.edu.service.MybatisJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
       return  success(mybatisJson);
    }

}
