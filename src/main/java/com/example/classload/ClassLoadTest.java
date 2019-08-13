package com.example.classload;

import java.lang.reflect.Field;

/**
 * Author by Sun, Date on 2019/3/19.
 * PS: Not easy to write code, please indicate.
 */
public class ClassLoadTest {

    public static void main(String[] args) {
        // classForName();
        classLoader();

    }


    private static void classLoader() {
        try {
            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.example.classload.Bean");
            for (Field field : aClass.getFields()) {
                String name = field.getName();
                if(name.equals("a")){
                    System.out.println("字段名称:"+name+"字段值:"+field.get(null));
                }
                if(name.equals("b")){
                    System.out.println("字段名称:"+name+"字段值:"+field.get(new Bean()));
                }

            }
            Object o = aClass.newInstance();
            Bean beanInstance = (Bean) o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void classForName() {
        try {
            Class<?> aClass = Class.forName("com.example.classload.Bean");
            Object o = aClass.newInstance();
            Bean bean = (Bean) o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
