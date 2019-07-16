package com.yasuo.framework.base.exception;

/**
 * @author ：liming
 * @date ：2019/7/16 13:05
 * @description：
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -1016834744093782716L;
    private int code;
    private Object data;

    public ServiceException() {
        super();
    }

    public ServiceException(int code) {
        super();
        this.code = code;
    }

    public ServiceException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message) {
        super(message);
        this.code = -1;
    }


    public ServiceException(BaseErrorCode.ErrorCode errorCode) {
        super(errorCode.getDesc());
        this.code = errorCode.getCode();
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(int code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }



}
