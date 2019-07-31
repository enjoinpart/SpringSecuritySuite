package com.github.edu.thread.t4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：liming
 * @date ：2019/7/25 10:55
 * @description： condition重新实现线程任务调度
 */
public class TMall {


    Lock lock = new ReentrantLock();

    Condition push = lock.newCondition();
    Condition take = lock.newCondition();

    private int count = 0;

    //设置最大上限
    private final int MAX_COUNT = 100;


    public void push() {
        lock.lock();

        while (count >= MAX_COUNT) {
            System.out.println("数量已达上限,生产者停止生产.");
            //休眠
            try {
                push.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "生产者进行生产,当前仓库数量:" + count);
        //唤醒消费者
        take.signal();
        lock.unlock();

    }

    public void take() {
        lock.lock();
        while (count<=0){
            try {
                take.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前库存为0,消费者停止消费");
        }
        count--;
        push.signal();
        System.out.println(Thread.currentThread().getName()+"消费者进行消费，当前数量为:"+count);
        lock.unlock();
    }

}
