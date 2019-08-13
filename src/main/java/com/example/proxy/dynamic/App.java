package com.example.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * Author by Sun, Date on 2019/1/14.
 * PS: Not easy to write code, please indicate.
 */
public class App {
    public static void main(String[] args) {
        Action man = (Action) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Action.class}, new MyInvocationHandler(new Man()));
        Action woman = (Action) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Action.class}, new MyInvocationHandler(new Woman()));
        // man.doSomething();
        // woman.doSomething();


        Woman woman1 = new Woman();
        Action instance = (Action) Proxy.newProxyInstance(woman1.getClass().getClassLoader(), woman1.getClass().getInterfaces(), (proxy, method, args1) -> {
            if (method.getName().equals("doSomething"))
                System.out.println("is doSomething proxy DO !");
            return method.invoke(woman1,args1);
        });
        instance.doSomething();

    }

}
