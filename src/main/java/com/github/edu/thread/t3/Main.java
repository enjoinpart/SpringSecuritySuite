package com.github.edu.thread.t3;

/**
 * @author ：liming
 * @date ：2019/7/25 10:03
 * @description：
 */
public class Main {

    public static void main(String[] args) {
        TMall tMall=new TMall();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();

        new Thread(new TargetTake(tMall)).start();






    }
}
