package com.example.reflect;

import java.lang.reflect.Field;

/**
 * Author by Sun, Date on 2019/3/15.
 * PS: Not easy to write code, please indicate.
 * 属性字段无get/set方法时的属性取赋值方法
 */
public class FieldTest {

    public static void main(String[] argv)
            throws IllegalArgumentException, SecurityException,
            IllegalAccessException, NoSuchFieldException {
        MyBean instance = new MyBean();
        editValue(instance, "message", "Shht! Don't tell anyone!");
        System.out.println("The message is '" + getValue(instance, "message"));
    }

    /**
     * 只有在安全管理器允许的情况下才允许这种操作。默认情况下，Java不会安装任何安全管理器，
     * 因此在通过IDE或命令行启动的独立程序中，使用此技术不会有任何问题。我也试过，在Tomcat下的Spring应用程序中，它仍在工作。
     * Bean:需要操作的bean对象
     * filedName:需要操作的字段名称
     * Value:需要给filedName赋的值
     **/
    private static void editValue(Object bean, String fieldName, Object value) throws
            IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {
        Field privateVar = bean.getClass().getDeclaredField(fieldName);
        //设置允许该字段的读取和写入
        privateVar.setAccessible(true);
        //为该字段赋值
        privateVar.set(bean, value);
        //取得该字段的值
        privateVar.get(bean);
    }

    private static Object getValue(Object bean, String fieldName) throws
            IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {
        Field privateVar = bean.getClass().getDeclaredField(fieldName);
        privateVar.setAccessible(true);
        return privateVar.get(bean);
    }


    private static class MyBean {
        private String message;
    }
}
