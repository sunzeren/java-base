package com.example.thread.concurrent;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

/**
 * Author by Sun, Date on 2019/4/20.
 * PS: Not easy to write code, please indicate.
 */
public class ConcurrentTestForInt {
    private static int a = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                getCount();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                getCount();
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                getCount();
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void getCount() {
        a++;
        System.out.println(a);
    }
}
