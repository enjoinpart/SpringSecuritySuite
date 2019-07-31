package com.github.edu.thread.t4;

/**
 * @author ：liming
 * @version ：
 * @since ：2019/7/25 11:27
 */
public class Main {

    public static void main(String[] args) {

        TMall tMall=new TMall();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetPush(tMall)).start();
        new Thread(new TargetTaker(tMall)).start();
        new Thread(new TargetTaker(tMall)).start();
        new Thread(new TargetTaker(tMall)).start();








    }

}
