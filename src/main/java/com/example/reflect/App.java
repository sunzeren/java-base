package com.example.reflect;

import com.example.base.bean.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author by Sun, Date on 2019/4/19.
 * PS: Not easy to write code, please indicate.
 *
 * 反射,动态执行
 */
public class App {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.example.base.bean.Person");
            Object o = aClass.newInstance();
            for (Field field : aClass.getFields()) {
                System.out.println("字段名:"+field.getName());
            }
            for (Method method : aClass.getMethods()) {
                System.out.println("方法名:"+method.getName());
                if(method.getName().equals("toString")){
                    System.out.println("执行toString");
                    System.out.println(method.invoke(o));
                }
            }
            if(o instanceof com.example.base.bean.Person){
                System.out.println("该对象为Person类");
                com.example.base.bean.Person person = (Person) o;
                System.out.println(person.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
