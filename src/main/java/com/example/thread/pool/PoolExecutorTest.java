package com.example.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ZeRen.
 * @Date: 2019/11/16 13:46
 */
public class PoolExecutorTest {

    private static ExecutorService pool = new ThreadPoolExecutor(1, 3,
            1L, TimeUnit.SECONDS,
            new SynchronousQueue<>());

    public static void main(String[] args) {
        int count = 3;

        submitTask(count);

        System.out.println("主线程 开始休眠");
        try {
            Thread.sleep(40 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程休眠 35 秒后开始提交任务");
        submitTask(3);


        try {
            pool.shutdown();
            boolean b = pool.awaitTermination(5, TimeUnit.SECONDS);
            if (b) {
                System.out.println("任务已执行完毕");
            } else {
                System.out.println("任务已超时,执行关闭线程池");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void submitTask(int count) {
        for (int i = 0; i < count; i++) {
            pool.submit(() -> {
                try {
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行任务完毕");
            });
        }
    }
}
