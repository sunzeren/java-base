package com.example.base.finalTest;

/**
 * Author by Sun, Date on 2019/4/1.
 * PS: Not easy to write code, please indicate.
 */
public class FinalTest {

    public static void main(String[] args) {

        //此时相当于声明了一个String,为不可变,
        //也就是说,后面的所有引用中o都指向常量池中的Hello
        Object o = "Hello";
        foo(o);
        System.out.println(o);//打印结果依旧是"Hello"

    }

    //此时已经进入栈区!o变量的修改只在此方法内有效
    static void foo(Object o) {
        //此时的o是在栈中,方法执行完毕后销毁
        o = "Goodbye";
        //以上相当于
        // o = new String("Goodbye");
    }

}
