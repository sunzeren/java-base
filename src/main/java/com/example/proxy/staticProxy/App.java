package com.example.proxy.staticProxy;

/**
 * Author by Sun, Date on 2019/1/14.
 * PS: Not easy to write code, please indicate.
 * 静态代理
 */
public class App {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealObject());
        Proxy proxy2 = new Proxy(new RealObject2());
        proxy.doSomething();
        proxy2.doSomething();
    }
}
