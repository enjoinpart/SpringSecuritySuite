package com.github.edu.controller;

import com.github.edu.base.controller.APIResponse;
import com.github.edu.base.controller.BaseController;
import com.github.edu.base.exception.ServiceException;
import com.github.edu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：liming
 * @date ：2019/7/18 10:14
 * @description：
 */
@RestController
public class TestController extends BaseController {


    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }



    @GetMapping("/test")
    @ResponseBody
    public APIResponse test(){
        int  i=testService.test();
        return  success(i);
    }

    @GetMapping("/serviceexception")
    @ResponseBody
    public APIResponse serviceException(){
       throw  new ServiceException(-1,"访问出错");
    }




}
