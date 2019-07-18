package com.github.edu.base.exception;

import com.github.edu.base.utils.EnumCodeOf;

/**
 * @author ：liming
 * @date ：2019/7/16 13:06
 * @description：
 */
public interface BaseErrorCode {


    int getCode();

    String getDesc();

    enum ErrorCode implements BaseErrorCode {

        /**
         * 未知的错误
         */
        UNEXPECTED_ERROR(-1001, "未知的错误"),
        /**
         * 请求失败
         */
        REQUEST_WAS_ABORTED(-1002, "请求失败"),
        /**
         * 数据更新失败
         */
        SAVE_WAS_ABORTED(-1003, "数据更新失败"),
        /**
         * 未知的错误
         */
        DELETE_WAS_ABORTED(-1004, "数据删除失败"),
        /**
         * 数据获取失败
         */
        DATA_ACQUISITION_FAILED(-1005, "数据获取失败"),
        /**
         * 参数校验失败
         */
        PARAM_CHECK_FAILED(-1006, "参数校验失败"),
        /**
         * 登录超时
         */
        USER_NO_LOGIN(-1007, "登录超时，请重新登录"),
        /**
         * 请求参数有误
         */
        REQUEST_PARAM_ERROR(-1008, "请求参数有误，请您稍后再试"),
        /**
         * 处理出错
         */
        EXCEL_EXPORT_ERROR_WORK_BOOK_EMPTY(-1009, "Excel 处理出错,workBook 为空.请确认调用方式是否正确........"),
        /**
         * 请先登录
         */
        USER_NONE_LOGIN(-1011 ,"请先登录"),
        /**
         * 暂无数据
         */
        DATA_NULL(-1010, "暂无数据"),;

        int code;
        String desc;

        ErrorCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static ErrorCode codeOf(int code) {
            return EnumCodeOf.codeOf(code, ErrorCode.class);
        }

        public static ErrorCode codeOf2(int code) {
            for (ErrorCode errorCode : values()) {
                if (errorCode.code == code) {
                    return errorCode;
                }
            }
            return null;
        }

        @Override
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        @Override
        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
