package com.example.base.builder;

/**
 * Author by Sun, Date on 2019/3/2.
 * PS: Not easy to write code, please indicate.
 * Builder设计模式
 */

public class APP {
    public static void main(String[] args) {
        //此步为创建Builder实例,紧接着调用,builder()方法来构建Student实例
        Student.Builder builder = new Student.Builder().name("szr").age(1);
        //
        Student         student = new Student.Builder().name("szr").age(21).builder();
    }

}
