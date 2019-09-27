package com.example.thread.pool.task;

import com.example.thread.pool.ThreadPool;

import java.util.concurrent.Callable;

/**
 * Author by Sun, Date on 2019/9/8.
 * PS: Not easy to write code, please indicate.
 */
public class CallableTask implements Callable<Integer> {

    public static int a = 1;

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        // System.out.println(Thread.currentThread().getName());
        // int second = 5;
        // System.out.println("进入call()方法,本线程将休眠" + second + "秒");
        // Thread.sleep(1000 * second);
        // System.out.println("call()休眠结束");

        return ThreadPool.atomicInteger.addAndGet(1);
    }
}
