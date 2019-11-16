package com.example.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ZeRen.
 * @Date: 2019/11/16 13:46
 */
public class PoolExecutorTest {

    private static ExecutorService pool = new ThreadPoolExecutor(1, 3,
            2L, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());

    public static void main(String[] args) {
        int count = 10;

        for (int i = 0; i < count; i++) {
            pool.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行任务完毕");
            });
        }
        try {
            pool.shutdown();
            boolean b = pool.awaitTermination(5, TimeUnit.SECONDS);
            if (b) {
                System.out.println("任务已执行完毕");
            } else {
                System.out.println("is false");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
