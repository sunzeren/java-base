package com.example.thread;

import com.example.classload.Bean;

import java.util.concurrent.TimeUnit;

/**
 * Author by Sun, Date on 2019/1/29.
 * PS: Not easy to write code, please indicate.
 */
public class ThreadLocalDemo {

    /**
     * @Description 1.ThreadLocal对象通常是private static fields
     * 2.线程运行结束后可以对该线程的变量副本进行回收，除非该副本有别的引用
     * 3.关键字：副本，线程独享
     **/
    //使用该变量时,为线程安全的,各线程之间不共享局部变量
    private static ThreadLocal<String> userId = ThreadLocal.withInitial(() -> "init_id");
    //使用平常的局部变量各线程之间共享局部变量
    // static String userId = "init _id";

    public static void main(String[] args) {

        //thread1和thread2,两个线程的目的只有两个
        //1.读取打印userId,
        //2.读取完毕后,更改userId的值

        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("线程1: " + userId.get());
                userId.set("id1");
                System.out.println("线程1: " + userId.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"线程1");

        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("线程2: " + userId.get());
                userId.set("id2");

                TimeUnit.SECONDS.sleep(2);
                System.out.println("线程2: " + userId.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2");


        Thread thread3 = new Thread(() ->{
            while(true){
                try {
                    Bean bean = new Bean();
                    TimeUnit.MILLISECONDS.sleep(50);
                    System.out.println("-----"+ThreadLocalDemo.userId.get()+"------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程3");

        thread1.start();
        thread2.start();
        thread3.start();


    }

}
