package com.example.ioc.di.interface_di;

/**
 * Author by Sun, Date on 2019/3/14.
 * PS: Not easy to write code, please indicate.
 */
public class App {

    private static InterfaceA interfaceA;

    public static void main(String[] args) {
        try {
            //既创建一个类的实例,将其强制转换类型为该接口类型
             Object o   = Class.forName("com.example.ioc.di.interface_di.ClassA").newInstance();
            interfaceA = (InterfaceA) o;
            interfaceA.say();
            interfaceA.saySomething();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
