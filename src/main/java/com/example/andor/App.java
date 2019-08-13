package com.example.andor;

/**
 * @Author by Sun, Date on 2019/1/28.
 * @PS: Not easy to write code, please indicate.
 * @describe &&,||,&,|的区别
 */
public class App {

    // Sun 2019/1/28 &&,||,&,|的区别
    // 当&&左边为false时,右边不执行,当||左边为true时,右边不执行
    // | 和 & 不管条件如何, 左右两边都会执行

    public static void main(String[] args) {
        if (falseMethod() && trueMethod()) {
            System.out.println("条件判断成功");
        }
        if (trueMethod() | falseMethod()) {
            System.out.println("条件判断成功");
        }
    }

    private static boolean falseMethod() {
        System.out.println(" this is falseMethod");
        return false;
    }

    private static boolean trueMethod() {
        System.out.println(" this is trueMethod");
        return true;
    }
}
