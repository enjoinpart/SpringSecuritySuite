package com.github.edu.thread.t3;

/**
 * @author ：liming
 * @date ：2019/7/25 9:49
 * @description： 生产者消费者
 */
public class TMall {


    private int count;
    //设置上限
    private final int MAX_COUNT=100;

    public synchronized void push() {
        while (count>=MAX_COUNT){
            System.out.println("容量达到最大，生产者停止生产");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" 生产者进行生产...");
        count++;
        System.out.println("当前数量为:"+count);
        notifyAll();
    }

    public synchronized void take() {
        while (count<=0){
            System.out.println("剩余量为0。消费者停止消费。");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+" 消费者进行消费...");
        count--;
        System.out.println("当前数量为:"+count);
        notifyAll();
    }


}
