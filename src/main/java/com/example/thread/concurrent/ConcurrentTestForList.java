package com.example.thread.concurrent;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Author by Sun, Date on 2019/4/20.
 * PS: Not easy to write code, please indicate.
 */
public class ConcurrentTestForList {
    private static Vector<String> list;
    static{
        // list = Lists.newArrayList("init", "init", "init", "init", "init");
        list = new Vector<>();
        list.add("init");
        list.add("init");
        list.add("init");
        list.add("init");
        list.add("init");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < list.size(); i++) {
                list.remove(i);
                list.add("1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < list.size(); i++) {
                list.remove(i);
                list.add("2");
            }
        });


        System.out.println("before:");
        list.stream().forEach(System.out::println);
        thread1.start();
        thread2.start();

        System.out.println("after:");
        list.stream().forEach(System.out::println);

    }
}
