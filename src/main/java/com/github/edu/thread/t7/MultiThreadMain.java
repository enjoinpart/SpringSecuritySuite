package com.github.edu.thread.t7;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：liming
 * @version ：
 * @since ：2019/7/25 15:20
 */
public class MultiThreadMain {

    public static void main(String[] args) {

        ExecutorService threadPool=Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> System.out.println(Singleton2.getInstance()));
        }
        threadPool.shutdown();
    }
}
