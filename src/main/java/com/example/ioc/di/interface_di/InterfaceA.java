package com.example.ioc.di.interface_di;

/**
 * Author by Sun, Date on 2019/3/14.
 * PS: Not easy to write code, please indicate.
 */
public interface InterfaceA {
    void saySomething();

    default void say(){
        System.out.println("is ok");
    }
}
