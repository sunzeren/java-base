package com.example.lambda;

/**
 * Author by Sun, Date on 2019/3/25.
 * PS: Not easy to write code, please indicate.
 */

public class ConstructorReference {
    public static void main(String[] arg){
        MyInterface in = MyClass::new;
        MyClass myClass = new MyClass();
        System.out.println("->"+in.getMeMyObject());
        System.out.println("->"+myClass);


    }
}
interface MyInterface{
    MyClass getMeMyObject();
    default void saySome(){
        System.out.println("is ok");
    }
}
class MyClass{
    MyClass(){}
}
