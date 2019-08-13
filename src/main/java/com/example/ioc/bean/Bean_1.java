package com.example.ioc.bean;

import com.example.base.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author by Sun, Date on 2019/3/11.
 * PS: Not easy to write code, please indicate.
 * @Bean 为方法级别的注解,声明的方法,默认将方法名称作为Spring bean来管理
 * 可使用name来定义Bean的名称
 */
@Configuration
public class Bean_1 {

    @Bean(name = "person")
    public Person person(){
        Person person = new Person();
        person.setGender("this is Bean_1 gender !");
        person.setName("this is Bean_1 name !");
        return person;
    }

    @Bean
    public PersonService getPersonService(){
        PersonService personService = new PersonService();
        personService.setPerson(person());
        return personService;
    }

}
