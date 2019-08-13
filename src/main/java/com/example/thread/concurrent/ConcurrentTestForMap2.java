package com.example.thread.concurrent;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by Sun, Date on 2019/4/20.
 * PS: Not easy to write code, please indicate.
 * HashMap与ConcurrentHashMap的区别于应用场景
 */
public class ConcurrentTestForMap2 {

    public static void main(String[] args) {
        /** 全局HashMap*/
        HashMap<Integer, Integer> hashMap = new HashMap();
        hashMap.put(0, 0);

        /** 多线程编辑100次*/
        for (int i = 0; i < 100; i++) {
            new Thread(new EditThread(hashMap)).start();
        }

        /** 读取线程*/
        new Thread(new ReadThread(hashMap)).start();
        /** 输出最终结果*/
        System.out.println("Demo1 main value " + hashMap.get(0));
    }
}

class EditThread implements Runnable {

    Map<Integer, Integer> hashMap;

    public EditThread(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        hashMap.put(0, hashMap.get(0) + 1);
    }
}

class ReadThread implements Runnable {

    Map<Integer, Integer> hashMap;

    public ReadThread(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        System.out.println("value " + hashMap.get(0));
    }
}

