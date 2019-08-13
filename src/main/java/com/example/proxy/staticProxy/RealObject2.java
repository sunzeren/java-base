package com.example.proxy.staticProxy;

/**
 * Author by Sun, Date on 2019/1/14.
 * PS: Not easy to write code, please indicate.
 */
public class RealObject2 implements Action {

    @Override
    public void doSomething() {
        System.out.println("RealObject for 2 DoSomething");
    }
}
