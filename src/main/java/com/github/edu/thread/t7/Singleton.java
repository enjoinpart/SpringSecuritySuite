package com.github.edu.thread.t7;

/**
 * @author ：liming
 * @version ：
 * @since ：2019/7/25 15:08
 */
public class Singleton {

    private static Singleton instance=new Singleton();

    private Singleton() {
    }

    public  static Singleton getInstance(){
        return  instance;
    }
}
