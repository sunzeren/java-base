package com.example.lambda;

import com.example.lambda.bean.Animal;

import java.util.function.Consumer;

/**
 * Author by Sun, Date on 2019/3/22.
 * PS: Not easy to write code, please indicate.
 */
public class LambdaTest {

    void lambdaTest(Consumer<String> consumer){
        consumer.accept(test());
    }

    public String test(){
        return "---isTest!---";
    }
}
