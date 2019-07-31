package com.github.edu.thread.t4;

/**
 * @author ：liming
 * @version ：
 * @since ：2019/7/25 11:07
 */
public class TargetTaker implements Runnable {

    private TMall tMall;

    public TargetTaker(TMall tMall) {
        this.tMall = tMall;
    }

    @Override
    public void run() {
        while (true){
            tMall.take();
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
