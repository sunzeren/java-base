package com.example.classload;

/**
 * Author by Sun, Date on 2019/3/19.
 * PS: Not easy to write code, please indicate.
 */

public class Bean{

    static{
        System.out.println("静态代码块执行了");
    }

    public static String a = "a 是静态的";
    public  String b = "b 不是静态的";
    private  String c = "c 是私有的";

    public Bean() {
        System.out.println("bean 被实例化了");
    }

    public void init(){
        System.out.println("静态方法执行了");
        if(a!=null){
            System.out.println(a);
        }else{
            System.out.println("a 为null");
        }
    }

    public void say(){
        System.out.println("今天天气真好 :)");
    }

    public static String getA() {
        return a;
    }

    public static void setA(String a) {
        Bean.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}