package com.example.base.list;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Author by Sun, Date on 2019/4/17.
 * PS: Not easy to write code, please indicate.
 */
public class VectorTest {
    private Vector list = new Vector();
    // private ArrayList list = new ArrayList();

    public static void main(String[] args) {
        //Vector 是基于数组的
        VectorTest vectorTest = new VectorTest();
        // list.add("1");
        // list.add("2");
        // list.add("3");
        // System.out.println("list [0] : "+list.get(0));
        // list.addElement("4");
        // list.elementAt(3);
        for (int i = 0; i < 10; i++) {
            vectorTest.list.add("init element"+i);
        }

        Thread thread1 = new Thread(() -> {
            // synchronized (vectorTest.list){
            try {
                System.out.println("thread 1 the size :"+vectorTest.list.size());
                vectorTest.list.stream().forEach(System.out::println);
                TimeUnit.SECONDS.sleep(2);
                System.out.println(vectorTest.list.isEmpty());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // }
        });
        Thread thread2 = new Thread(() -> {
            // try {
            //     TimeUnit.SECONDS.sleep(3);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            System.out.println("thread2 : "+vectorTest.list.isEmpty());
            vectorTest.list.clear();
            System.out.println("thread2 : is clear !");
            System.out.println("thread2 :"+vectorTest.list.isEmpty());
            // vectorTest.list.add("this is thread2");
            // vectorTest.list.forEach(System.out::println);
        });

        Thread thread = new Thread(() -> {
            // while (true) {
                try {
                    vectorTest.list.forEach(System.out::println);
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            // }
        });


        thread1.start();
        thread2.start();
        // thread.start();
    }
}
