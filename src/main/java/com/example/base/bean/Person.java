package com.example.base.bean;

/**
 * Author by Sun, Date on 2019/3/2.
 * PS: Not easy to write code, please indicate.
 */
public class Person {
    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private static void say(){
        System.out.println("i myName the hello");
    }
    public static void eat(){
        System.out.println("i am eating food");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        System.out.println(gender);
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
