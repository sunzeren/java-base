package com.example.request;

import com.example.base.bean.Person;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Author by Sun, Date on 2019/3/12.
 * PS: Not easy to write code, please indicate.
 */
@RestController
public class RequestTemplate {


    @GetMapping("/getTest")
    public String test(@RequestParam("testID") String testID, HttpServletRequest request){
        StringBuffer msg = new StringBuffer();
        String host = request.getHeader("host");
        msg.append("host:"+host);
        msg.append("--testID:"+testID);
        System.out.println(msg);
        System.out.println("-----------");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName+":"+headerValue);
        }
        return msg.toString();
    }

    @PostMapping("/postTest")
    public String test(@RequestBody Person person, HttpServletRequest request){
        if(null==person.getName()){
            return "请告诉我您的名字~";
        }
        System.out.println(person.toString());
        return "hello!"+person.getName();
    }

    @GetMapping("/requestTest")
    public String requestTest(){
        StringBuffer msg = new StringBuffer();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        for (Cookie cookie : request.getCookies()) {
            msg.append("</br>");
            msg.append("<b>cookie:</b>");
            msg.append("name:"+cookie.getName()+"\t value:"+cookie.getValue());
        }
        //为前端添加cookie,前端js可通过document.cookie来获取
        response.setHeader("Set-Cookie","NAME=szr; Expires=DATE; Path=/index; Domain=localhost; SECURE");
        response.setHeader("testHeader","Hello world!");

        //新增一个cookie
        Cookie cookie = new Cookie("newCookie", "newCookieValue");
        // cookie.setHttpOnly(true);
        // cookie.setPath(true);
        response.addCookie(cookie);

        msg.append("</br></br>");
        msg.append("<b>session:</b>");
        response.getHeaderNames().forEach(msg::append);

        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }
        return msg.toString();
    }

    @GetMapping("/cookieTest")
    public String cookieTest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer msg = new StringBuffer();
        for (Cookie cookie : request.getCookies()) {
            msg.append("</br>");
            msg.append(cookie.getName()+":"+cookie.getValue());
        }
        return msg.toString();
    }

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8787/images/getFile?file_id=5c8a10f9dbc60e32d8146ce6")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "42f5ceb7-8af6-461b-aa95-57126466c95a")
                .build();

        try {
            Response response = client.newCall(request).execute();
            response.body().bytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
