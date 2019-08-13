package com.example.base.string;

import com.fasterxml.jackson.databind.util.BeanUtil;

import java.util.Formattable;
import java.util.Formatter;

/**
 * Author by Sun, Date on 2019/3/29.
 * PS: Not easy to write code, please indicate.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.stringTest();

        String str = new String();
        String str1 = new String("");
        //str和str1都是""空串
        System.out.println(str.equals(str1));

        //String的格式化输出
        test.formatSout();
    }

    private void stringTest() {
        String a = "10";
        String b = "10";
        String c = new String("10");
        String d = new String("10");

        System.out.println(a==c);
        c=c.intern();
        System.out.println(a==c);
    }

    private void formatSout(){
        System.out.println(String.format("'b':将参数格式化为boolean类型输出，'B'的效果相同,但结果中字母为大写。%b", false));
        System.out.println(String.format("'h':将参数格式化为散列输出，原理：Integer.toHexString(arg.hashCode())，'H'的效果相同,但结果中字母为大写。%h", "ABC"));
        System.out.println(String.format("'s':将参数格式化为字符串输出，如果参数实现了 Formattable接口，则调用 formatTo方法。'S'的效果相同。%s", 16));
        System.out.println(String.format("FormatImpl类实现了Formattable接口：%s", new FormatImpl()));
        System.out.println(String.format("'c':将参数格式化为Unicode字符，'C'的效果相同。%c", 'A'));
        System.out.println(String.format("'d':将参数格式化为十进制整数。%d", 11));
        System.out.println(String.format("'o':将参数格式化为八进制整数。%o", 9));
        System.out.println(String.format("'x':将参数格式化为十六进制整数。%x", 17));
        System.out.println(String.format("'e':将参数格式化为科学计数法的浮点数，'E'的效果相同。%E", 10.000001));
        System.out.println(String.format("'f':将参数格式化为十进制浮点数。%f", 10.000001));
        System.out.println(String.format("'g':根据具体情况，自动选择用普通表示方式还是科学计数法方式，'G'效果相同。10.01=%g", 10.01));
        System.out.println(String.format("'g':根据具体情况，自动选择用普通表示方式还是科学计数法方式，'G'效果相同。10.00000000005=%g", 10.00000000005));
        System.out.println(String.format("'a':结果被格式化为带有效位数和指数的十六进制浮点数，'A'效果相同,但结果中字母为大写。%a", 10.1));
        System.out.println(String.format("'t':时间日期格式化前缀，会在后面讲述"));
        System.out.println(String.format("'%%':输出%%。%%"));
        System.out.println(String.format("'n'平台独立的行分隔符。System.getProperty(\"line.separator\")可以取得平台独立的行分隔符，但是用在format中间未免显得过于烦琐了%n已经换行"));
    }

    private static class FormatImpl implements Formattable {

        @Override
        public void formatTo(Formatter formatter, int flags, int width, int precision) {
            formatter.format("我是Formattable接口的实现类");
        }
    }
}
