package com.example.proxy.staticProxy;

/**
 * Author by Sun, Date on 2019/1/14.
 * PS: Not easy to write code, please indicate.
 */
public class Proxy implements Action {
    private Action realObject;

    public Proxy(Action realObject) {
        this.realObject = realObject;
    }

    @Override
    public void doSomething() {
        System.out.println("静态代理执行");
        realObject.doSomething();
    }
}
