package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Author by Sun, Date on 2019/3/4.
 * PS: Not easy to write code, please indicate.
 */
@Component
public interface Dao {

    void saySomeThing();

}
