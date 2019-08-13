package com.example.ioc.bean;


import com.example.base.bean.Person;

/**
 * Author by Sun, Date on 2019/3/11.
 * PS: Not easy to write code, please indicate.
 */
public class PersonService {

    private Person person;

    public void setPerson(Person person){
        this.person = person;
    }

    public void toDetail(){
        System.out.println("姓名:"+person.getName());
        System.out.println("年龄:"+person.getGender());
    }
}
