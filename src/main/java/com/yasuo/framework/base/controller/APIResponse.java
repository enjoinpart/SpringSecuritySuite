package com.yasuo.framework.base.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author ：liming
 * @date ：2019/7/16 12:36
 * @description：
 */
public class APIResponse<T> implements Serializable {

    private static final long serialVersionUID = 5241526151768786394L;

    private final String ver = "1.0";
    private boolean ret;
    @JsonInclude(NON_NULL)
    private String msg;
    private int code;
    @JsonInclude(NON_NULL)
    private T data;

    public APIResponse() {
    }

    private APIResponse(T t) {
        this.msg = "成功";
        this.ret = true;
        this.data = t;
        this.code = 0;
    }

    private APIResponse(String msg, T t) {
        this.ret = false;
        this.msg = msg;
        this.data = t;
        this.code = -1;
    }

    private APIResponse(int errcode, String msg, T t) {
        this.ret = false;
        this.msg = msg;
        this.code = errcode;
        this.data = t;
    }

    public static <T> APIResponse<T> returnSuccess() {
        return new APIResponse<T>(null);
    }

    public static <T> APIResponse<T> returnSuccess(T t) {
        return new APIResponse<T>(t);
    }

    public static <T> APIResponse<T> returnFail(String msg) {
        return new APIResponse<T>(msg, null);
    }

    public static <T> APIResponse<T> returnFail(String msg, T t) {
        return new APIResponse<T>(msg, t);
    }

    public static <T> APIResponse<T> returnFail(int errcode, String msg) {
        return new APIResponse<T>(errcode, msg, null);
    }

    public static <T> APIResponse<T> returnFail(int errcode, String msg, T t) {
        return new APIResponse<T>(errcode, msg, t);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((msg == null) ? 0 : msg.hashCode());
        result = prime * result + (ret ? 1231 : 1237);
        result = prime * result + code;
        result = prime * result + ver.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        APIResponse that = (APIResponse) o;
        if (code != that.code) {
            return false;
        }
        if (ret != that.ret) {
            return false;
        }
        if (data != null || that.data != null) {
            return false;
        }
        return !(msg != null || that.msg != null);
    }

    @Override
    public String toString() {
        return "APIResponse [" +
                "ver='" + ver + '\'' +
                ", ret=" + ret +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                ']';
    }

}
