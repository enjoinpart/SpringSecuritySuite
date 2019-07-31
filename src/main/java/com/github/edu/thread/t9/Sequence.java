package com.github.edu.thread.t9;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：liming
 * @version ：
 * @since ：2019/7/25 16:23
 */
public class Sequence {


    private AtomicInteger value=new AtomicInteger(0);

    public int getNext(){
        return  value.getAndIncrement();

    }

}
