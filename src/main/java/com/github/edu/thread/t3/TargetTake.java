package com.github.edu.thread.t3;

/**
 * @author ：liming
 * @date ：2019/7/25 10:02
 * @description：
 */
public class TargetTake implements Runnable {

    private TMall tMall;

    public TargetTake(TMall tMall) {
        this.tMall = tMall;
    }

    @Override
    public void run() {
        while (true){
            tMall.take();
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
