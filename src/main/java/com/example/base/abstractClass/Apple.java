package com.example.base.abstractClass;

/**
 * Author by Sun, Date on 2019/3/26.
 * PS: Not easy to write code, please indicate.
 * 抽象的类,拥有一些固定行为
 */
public class Apple extends Fruit{
    @Override
    public void myName() {
        System.out.println("is apple !");
    }

    public static void main(String[] args) {
        Fruit fruit = new Apple();
        fruit.say();
        fruit.myName();
    }
}
