package com.example.apo.interceptor;

import com.example.request.RequestTemplate;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Author by Sun, Date on 2019/4/7.
 * PS: Not easy to write code, please indicate.
 */
// @ControllerAdvice(basePackages = "com.example.request",assignableTypes = { RequestTemplate.class })
public class MyInterceptor extends HandlerInterceptorAdapter {
    public MyInterceptor() {
        super();
    }

    /**
     * This implementation always returns {@code true}.
     *
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("is preHandle");
        return super.preHandle(request, response, handler);
    }

    /**
     * This implementation is empty.
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("is postHandle");
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * This implementation is empty.
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("is afterCompletion");
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * This implementation is empty.
     *
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("is afterConcurrentHandlingStarted");
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
