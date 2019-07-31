package com.github.edu.thread.t4;

/**
 * @author ：liming
 * @date ：2019/7/25 10:57
 * @description ：生产者
 */
public class TargetPush implements Runnable {

    private TMall tMall;


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
