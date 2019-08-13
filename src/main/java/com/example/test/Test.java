package com.example.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author by Sun, Date on 2019/4/1.
 * PS: Not easy to write code, please indicate.
 */
public class Test {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    public static void main(String[] args) {
        int i = ID_GENERATOR.incrementAndGet();
        System.out.println(i);
    }
}
