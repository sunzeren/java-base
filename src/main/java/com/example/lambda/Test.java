package com.example.lambda;

import com.example.lambda.bean.Animal;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by Sun, Date on 2019/1/29.
 * PS: Not easy to write code, please indicate.
 * map的foreach方法
 */
public class Test {

    public static void main(String[] args) {
        //相当于重写左侧接口,参数列表为(in,in)的方法,其实现为{}中的方法体
        // doSomethingOverwrite();

        //使用lambda表达式,迭代map时做某些事
        Map<String, String> map = new HashMap<>();
        map.put("name", "孙泽仁");
        map.put("gender", "男");
        map.put("phone", "110");
        map.put("say", "hello word !");
        // HashMapTest.eachMapDoSomething(map);

        //::引用
        // eatTest();

        //s:Key s2:Value
        map.forEach((s, s2) ->
        System.out.println(s + " : " + s2));



        // List list = new ArrayList();
        // list.iterator().forEachRemaining();
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.lambdaTest(o -> {
            System.out.println("what is test ?");
            System.out.println(o);
        });

        Animal animal = (food) -> System.out.println(food);

        Thread thread = new Thread(() -> {
            System.out.println("lambda表达式");
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        });



    }
        //相当于重写左侧接口,参数列表为(int,int)的方法,其实现为{}中的方法体
        private static void doSomethingOverwrite () {
            SaySomething saySomething = (int a, int b) -> {
                System.out.println("两个数相加 :" + a + "," + b);
                return a + b;
            };
            int a = saySomething.sayNumber(1, 4);
            System.out.println(a);
        }

        //引用输出字符串
        private static void eatTest () {
            Animal a = System.out::print;
            a.eat("吃了个苹果");
        }
}
