package com.example.mvc.listener;

import com.example.constant.GlobalConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * EnvironmentListener
 */
@Slf4j
@Configuration
public class EnvironmentListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        GlobalConstant.APP_DEPLOY_TIME = new Date();
    }
}
