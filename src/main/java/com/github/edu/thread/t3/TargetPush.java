package com.github.edu.thread.t3;

/**
 * @author ：liming
 * @date ：2019/7/25 10:01
 * @description ：生产者
 */
public class TargetPush  implements  Runnable{

    private  TMall tMall;

    public TargetPush(TMall tMall) {
        this.tMall = tMall;
    }

    @Override
    public void run() {

        while (true){
            tMall.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
