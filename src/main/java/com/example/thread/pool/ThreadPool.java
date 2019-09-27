package com.example.thread.pool;

import com.example.thread.pool.task.CallableTask;
import com.example.thread.pool.task.RunnableTask;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author by Sun, Date on 2019/9/8.
 * PS: Not easy to write code, please indicate.
 */
public class ThreadPool {

    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static Integer integer = 0;

    private static Set<Future<CallableTask>> taskSet = new HashSet<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        // poolTest();
        // concurrentAddTest();
        shutDownTest();
    }

    public static void shutDownTest(){
        for (int i = 0; i < 1000000; i++) {
            pool.submit(new RunnableTask());
        }
        pool.shutdown();
        try {
            //此步骤会阻塞线程调用的线程,等待任务完成
            if (pool.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                System.out.println("线程池任务结束");
            } else {
                System.out.println("线程池任务在100毫秒内仍未结束,已被强制关闭");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("atomicInteger = " + atomicInteger);
        System.out.println("integer = " + integer);
    }

    public static void concurrentAddTest() {
        for (int i = 0; i < 100000; i++) {
            pool.submit(new RunnableTask());
        }
        System.out.println(atomicInteger);
        System.out.println(integer);
    }

    public static void poolTest() {
        pool.submit(new CallableTask());
        pool.submit(CallableTask::new);//这个任务并不会执行,即使显示的调用get()方法也不会执行
        pool.submit(new RunnableTask());
    }

    public static void futureTaskTest() {
        FutureTask<Integer> task = new FutureTask<>(new CallableTask());
        new Thread(task).start();
        try {
            System.out.println("task = " + task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        //调用get会阻塞线程
        System.out.println("is get after");
    }

}
