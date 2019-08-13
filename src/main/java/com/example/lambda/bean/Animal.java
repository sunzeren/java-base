package com.example.lambda.bean;

/**
 * Author by Sun, Date on 2019/3/22.
 * PS: Not easy to write code, please indicate.
 */
public interface Animal {

    void eat(String food);

    default void init(){
        System.out.println("小动物生成啦");
    }
}
