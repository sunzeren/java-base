package com.example.current;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ZeRen.
 * @Date: 2020/7/20 16:09
 * <p>
 * 使用 CountDownLatchTest ,实现多个线程,同时运行执行
 * 且主线程等待所有线程执行完毕后,再结束运行
 */
public class CountDownLatchTest {

    private AtomicInteger safeCount = new AtomicInteger(0);
    private int notSafeCount = 0;

    @Test
    public void run() {
        final int count = 1000;
        final CountDownLatch taskLatch = new CountDownLatch(count);
        final CountDownLatch mainLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    taskLatch.await();
                    exec();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mainLatch.countDown();
                }
            }).start();
            taskLatch.countDown();
        }
        System.out.println("所有线程启动完成");

        try {
            System.out.println("主线程等待所有线程执行完成");
            mainLatch.await();
            System.out.println("所有线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("安全的计数Count:" + safeCount);
        System.out.println("不安全的计数Count:" + notSafeCount);
        System.out.println("执行完毕");
    }

    public void exec() {
        try {
            // 模拟任务执行
            Thread.sleep(1000 * 2);
            safeCount.incrementAndGet();
            notSafeCount++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
