package com.example.base.statics;

import com.example.base.bean.Person;

/**
 * @Author: ZeRen.
 * @Date: 2019/11/18 11:57
 */
public class VariableTest {

    //此时声明的
    private Integer a = 128;
    //此处实则 调用Integer.valueOf(),使用了享元模式
    private Integer b = 121;

    //此处声明的对象,是VariableTest 的实例的,也就是每次 new VariableTest,时会新建一个对象
    private Person person = new Person();

    public static void main(String[] args) {
        VariableTest test = new VariableTest();
        VariableTest test_ = new VariableTest();

        System.out.println(test.a == test_.a);
        System.out.println(test.b == test_.b);
        System.out.println(test.person == test_.person);

    }
}
