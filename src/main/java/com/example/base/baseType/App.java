package com.example.base.baseType;

/**
 * Author by Sun, Date on 2019/1/17.
 * PS: Not easy to write code, please indicate.
 */
public class App {
    private static int a;
    private static short b;
    private static long c;
    private static boolean d;
    public static void main(String[] args) {
        System.out.println(d);
        System.out.println(e);

        char str = 0;
        System.out.println(str);

        byteTest();
    }

    private static char e;

    public static char getE() {
        return e;
    }

    public static void setE(char e) {
        App.e = e;
    }


    /**
     *
     *此为补码,第一位控制正负,所以当byte
     * 第一位为控制正负的
     *byte 127  : ‭0111 1111‬
     *byte 127+1: 1111 1111‬
     *所以byte 127+1 = -128
     * byte范围: 127 ~ -128
     */
    private static void byteTest() {
        byte x=127;
        x += 1;
        byte x1 = 127;
        x1=(byte)(x1+1);
        System.out.println(x);
        System.out.println(x1);
    }
}
