package com.example.base.builder;

/**
 * Author by Sun, Date on 2019/3/2.
 * PS: Not easy to write code, please indicate.
 * Builder设计模式
 */
public class Student {

    private String name;

    private int age;


    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Student builder(){
            return new Student(this);
        }
    }

}

