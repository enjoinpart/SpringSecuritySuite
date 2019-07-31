package com.github.edu.thread.t1;

/**
 * @author ：liming
 * @date ：2019/7/25 9:19
 * @description： 线程的交替执行
 */
public class Demo1 {


    private int flag = 0;

    public synchronized void a() {
        while (flag != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        flag++;
        notifyAll();
    }

    public synchronized void b() {
        while (flag != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("b");
        flag++;
        notifyAll();
    }

    public synchronized void c() {
        while (flag != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("c");
        flag = 0;
        notifyAll();
    }


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Thread thread1 = new Thread(new A(demo1));
        Thread thread2 = new Thread(new B(demo1));
        Thread thread3 = new Thread(new C(demo1));
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

