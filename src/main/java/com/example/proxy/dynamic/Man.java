package com.example.proxy.dynamic;

/**
 * Author by Sun, Date on 2019/1/14.
 * PS: Not easy to write code, please indicate.
 */
public class Man implements Action {
    public void run() {
        System.out.println("the man is run !");
    }

    public void eating(Fruit fruit) {
        System.out.println("the man eating fruit :" + fruit.value);
    }

    @Override
    public void doSomething() {
        System.out.println("the man is do Something");
    }

}
