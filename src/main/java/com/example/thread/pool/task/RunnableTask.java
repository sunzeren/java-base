package com.example.thread.pool.task;

import com.example.thread.pool.ThreadPool;

/**
 * Author by Sun, Date on 2019/9/9.
 * PS: Not easy to write code, please indicate.
 */
public class RunnableTask implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        // int second = 1;
        // System.out.println("进入run方法,本线程将休眠" + 1 + "秒");
        // try {
        //     Thread.sleep(1000 * second);
        //     System.out.println("run()休眠结束");
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        ThreadPool.atomicInteger.addAndGet(1);
        ThreadPool.integer++;
    }
}
