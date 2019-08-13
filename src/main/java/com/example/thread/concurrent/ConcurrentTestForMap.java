package com.example.thread.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Author by Sun, Date on 2019/4/20.
 * PS: Not easy to write code, please indicate.
 */
public class ConcurrentTestForMap {
        private static Map<String,String> map;
        static{
            // map = new HashMap();
            map = new ConcurrentHashMap();
            for (int i = 0; i < 1000; i++) {
                map.put("key-"+i,"init-value");
            }
        }

        public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < map.size(); i++) {
                    map.remove("key-"+i);
                    map.put("key-"+i,"thread-1");
                }
            });

            Thread thread2 = new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < map.size(); i++) {
                    map.remove("key-"+i);
                    map.put("key-"+i,"thread-2");
                }
            });


            System.out.println("before:");
            map.entrySet().forEach(System.out::println);

            Thread thread = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after:");
                map.entrySet().forEach(System.out::println);
            });


            thread1.start();
            thread2.start();
            thread.start();
        }

}
