package com.github.edu.thread.t6;

/**
 * @author ：liming
 * @version ：序列生成器
 * @since ：2019/7/25 14:31
 */
public class Sequence {
    private int value;
    public int getNext() {
        return value++;
    }
}
