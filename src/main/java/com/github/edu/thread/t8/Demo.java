package com.github.edu.thread.t8;

import java.util.Random;

/**
 * @author ：liming
 * @version ：
 * @since ：2019/7/25 15:44
 */
public class Demo {


    public static void main(String[] args) {


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行");
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行");
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行");
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行");
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行");
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
        }).start();

        while (Thread.activeCount() != 1) {
            //自旋等待
        }
        System.out.println("所有的线程都执行完毕了...");

    }

}
