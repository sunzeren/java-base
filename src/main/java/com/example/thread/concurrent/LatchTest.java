package com.example.thread.concurrent;

/**
 * Author by Sun, Date on 2019/4/19.
 * PS: Not easy to write code, please indicate.
 */

import java.util.Vector;
import java.util.concurrent.CountDownLatch;


public class LatchTest {

    public static void main(String[] args) throws InterruptedException {
        Vector list = new Vector();
        // ArrayList list = new ArrayList();
        // Collections.synchronizedList(list);
        // for (int i = 0; i < 10; i++) {
        //     list.add(0);
        // }

        Runnable taskTemp = new Runnable() {

            // 注意，此处是非线程安全的，留坑
            private int iCounter;

            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    // 发起请求
//                    HttpClientOp.doGet("https://www.baidu.com/");
//                     list.remove(0);
                    list.add(0);
                    iCounter++;
                    System.out.println(System.nanoTime() + " [" + Thread.currentThread().getName() + "] iCounter = " + iCounter);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        LatchTest latchTest = new LatchTest();
        latchTest.startTaskAllInOnce(5, taskTemp);
        System.out.println(list.size());
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public long startTaskAllInOnce(int threadNums, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threadNums);
        for (int i = 0; i < threadNums; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        // 使线程在此等待，当开始门打开时，一起涌入门中
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            // 将结束门减1，减到0时，就可以开启结束门了
                            endGate.countDown();
                        }
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long startTime = System.nanoTime();
        System.out.println(startTime + " [" + Thread.currentThread() + "] All thread is ready, concurrent going...");
        // 因开启门只需一个开关，所以立马就开启开始门
        startGate.countDown();
        // 等等结束门开启
        endGate.await();
        long endTime = System.nanoTime();
        System.out.println(endTime + " [" + Thread.currentThread() + "] All thread is completed.");
        return endTime - startTime;
    }
}
