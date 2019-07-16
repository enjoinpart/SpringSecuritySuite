package com.yasuo.framework.base.controller;

import com.yasuo.framework.base.exception.ServiceException;
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

    @ExceptionHandler(ServiceException.class)
    public APIResponse systemExceptionHandler(Exception exception, WebRequest request){
        log.error("systemException", exception);
        return  APIResponse.returnFail(exception.getMessage());
    }

    public APIResponse success() {
        return APIResponse.returnSuccess();
    }

    public <T> APIResponse success(T data) {
        return APIResponse.returnSuccess(data);
    }

    public APIResponse failure(String msg) {
        return APIResponse.returnFail(msg);
    }

    public APIResponse failure(String msg, int code) {
        return APIResponse.returnFail(msg, code);
    }

}
