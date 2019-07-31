package com.github.edu.thread.t5;

import com.google.common.collect.Lists;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：liming
 * @version ：数据库连接池
 * @since ：2019/7/25 14:07
 */
public class MyDataSource {

    private LinkedList<Connection> pool = Lists.newLinkedList();

    private static int INIT_CONNECTIONS = 10;
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String USER = "";
    private static final String PASS_WORD = "";
    private static final String URL = "";

    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MyDataSource() {
        for (int i = 0; i < INIT_CONNECTIONS; i++) {
            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASS_WORD);
                pool.addLast(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接
     *
     * @return
     */
    public Connection getConnection() {
        Connection connection = null;
        lock.lock();
        try {
            while (pool.size() <= 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (!pool.isEmpty()) {
                connection = pool.removeFirst();
            }
            return connection;
        } finally {
            lock.unlock();

        }
    }

    /**
     * 释放资源,回收到线程池当中
     */
    public void release(Connection connection) {
        if (connection != null) {
            lock.lock();
            try {
                pool.addLast(connection);
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }


}
