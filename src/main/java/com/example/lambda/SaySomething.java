package com.example.lambda;

/**
 * Author by Sun, Date on 2019/1/29.
 * PS: Not easy to write code, please indicate.
 */
public interface SaySomething {
    default void sayMessage(String message){
        System.out.println(message);
    };
    int sayNumber(int a, int b);
    // void sayNumbers(int a,int b,int c);

}
