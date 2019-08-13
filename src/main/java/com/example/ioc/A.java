package com.example.ioc;

import org.springframework.stereotype.Component;

/**
 * Author by Sun, Date on 2019/3/4.
 * PS: Not easy to write code, please indicate.
 */
@Component
public class A implements Dao{
    @Override
    public void saySomeThing() {
        System.out.println(" is A");
    }
}
