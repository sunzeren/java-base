package com.example.apo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author by Sun, Date on 2019/4/7.
 * PS: Not easy to write code, please indicate.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个，这里选择拦截所有请求地址，进入后判断是否有加注解即可
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
