package com.github.edu.thread.t2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：liming
 * @date ：2019/7/25 9:19
 * @description： 线程的交替执行
 */
public class Demo1 {
    private Lock lock = new ReentrantLock();
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();
    private Condition c = lock.newCondition();

    private int flag = 0;

    public void a() {

        lock.lock();
        while (flag != 0) {
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        flag++;
        b.signal();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        while (flag != 1) {
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("b");
        flag++;
        c.signal();
        lock.unlock();
    }

    public void c() {
        lock.lock();
        while (flag != 2) {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        flag = 0;
        a.signal();
        lock.unlock();
    }


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        A a = new A(demo1);
        B b = new B(demo1);
        C c = new C(demo1);
        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(b);
        Thread thread3 = new Thread(c);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class A implements Runnable {


    private Demo1 demo1;

    public A(Demo1 demo1) {
        this.demo1 = demo1;
    }

    @Override
    public void run() {

        while (true) {
            demo1.a();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B implements Runnable {


    private Demo1 demo1;

    public B(Demo1 demo1) {
        this.demo1 = demo1;
    }

    @Override
    public void run() {
        while (true) {
            demo1.b();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class C implements Runnable {


    private Demo1 demo1;

    public C(Demo1 demo1) {
        this.demo1 = demo1;
    }

    @Override
    public void run() {
        while (true) {
            demo1.c();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

