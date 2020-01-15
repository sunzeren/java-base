package com.example.base.bean;

/**
 * Author by Sun, Date on 2019/3/2.
 * PS: Not easy to write code, please indicate.
 */
public class Person {
    private String name;
    private String gender;
    private Gender genderOfEnum;

    public Person() {
    }

    public Person(Object name) {
        this.name = name.toString();
    }

    public Gender getGenderOfEnum() {
        return genderOfEnum;
    }

    public void setGenderOfEnum(Gender genderOfEnum) {
        this.genderOfEnum = genderOfEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }


    public enum Gender {
        WOMAN("女"),
        MAN("男");

        private String value;

        Gender(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
