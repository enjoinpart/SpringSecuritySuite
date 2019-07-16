package com.yasuo.framework.base.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author ：liming
 * @date ：2019/7/16 12:35
 * @description：
 */
@Slf4j
public class BaseController {

    @ExceptionHandler()
    public APIResponse systemExceptionHandler(Exception exception, WebRequest request){
        log.error("systemException", exception);
        return  APIResponse.returnFail(exception.getMessage());
    }

}
