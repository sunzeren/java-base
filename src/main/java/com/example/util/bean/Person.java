package com.example.util.bean;

import java.util.Date;

/**
 * Author by Sun, Date on 2019/2/25.
 * PS: Not easy to write code, please indicate.
 */
public class Person {

    private String name;
    private String age;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
