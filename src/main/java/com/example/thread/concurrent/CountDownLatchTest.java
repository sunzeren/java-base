package com.example.thread.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: ZeRen.
 * @Date: 2020/6/28 13:40
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("南京禄口机场_机长正在等待所有乘客登机");
        //CountDownLatch的计数器数量必须与线程的数量一致,否则可能出现一直等待的情况,即计数器不为0的情况
        //使用CountDownLatch 需要注意,子线程中的countDown()最好放到finnally里面,防止计数器不为0
        CountDownLatch latch = new CountDownLatch(4);

        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(new ThreadTest1(latch));
        ex.execute(new ThreadTest2(latch));
        ex.execute(new ThreadTest3(latch));
        //等待所有乘客来机场
        System.out.println("所有乘客都在赶飞机的路上");

        //latch.await(1,TimeUnit.SECONDS);//模拟超时等待的情况
        latch.await(); //模拟等待的情况,不考虑子线程的处理实际
        System.out.println("南京禄口机场_机长启动飞机起飞");
        ex.shutdown();
    }

    public static class ThreadTest1 extends Thread {

        CountDownLatch latch;

        public ThreadTest1() {

        }

        public ThreadTest1(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正在马鞍山,准备赶到南京坐飞机,需要1小时的车程到机场");
            latch.countDown();
        }
    }

    public static class ThreadTest2 extends Thread {

        CountDownLatch latch;

        public ThreadTest2() {

        }

        public ThreadTest2(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("正在徐州,准备赶到南京坐飞机,需要5小时的车程到机场");
            latch.countDown();
        }
    }

    public static class ThreadTest3 extends Thread {
        CountDownLatch latch;

        public ThreadTest3() {

        }

        public ThreadTest3(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("正在芜湖,准备赶到南京坐飞机,需要2小时的车程到机场");
            latch.countDown();
        }
    }
}
