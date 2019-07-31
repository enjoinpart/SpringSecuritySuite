package com.github.edu.thread.t7;

/**
 * @author ：liming
 * @version ：
 * @since ：2019/7/25 15:14
 */
public class Singleton2 {


    private static volatile Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

