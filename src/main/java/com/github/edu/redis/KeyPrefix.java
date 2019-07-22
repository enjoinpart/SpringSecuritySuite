package com.github.edu.redis;

/**
 * @author ：liming
 * @date ：2019/7/22 14:54
 * @description：
 */
public interface KeyPrefix {


    int expireSeconds();

    String getPrefix();

}
