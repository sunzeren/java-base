package com.example.ioc.bean;

import com.example.DemoApplication;
import com.example.base.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Author by Sun, Date on 2019/3/11.
 * PS: Not easy to write code, please indicate.
 */
@SpringBootApplication
public class App implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Autowired
    Bean_1 bean_1;
    @Autowired
    private ApplicationContext appContext;
    @Autowired
    private PersonService personService;

    @Autowired
    private Person person;
    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("person:"+person.toString());
        personService.toDetail();

        Person person = (Person) appContext.getBean("person");
        System.out.println("this is bean:"+person);
    }

}
