package com.example.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author by Sun, Date on 2019/3/27.
 * PS: Not easy to write code, please indicate.
 */
@WebServlet(name = "firstServlet", urlPatterns = "/firstServlet")  //标记为servlet，以便启动器扫描。
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行doGet ()");
        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行doPost()");
        super.doPost(req, resp);
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service()-->HttpServletResponse");
        super.service(req, resp);
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Service()-->ServletResponse");
        super.service(req, res);
    }
    @Override
    public void destroy() {
        System.err.println("servlet销毁了");
        super.destroy();
    }
    @Override
    public void init() throws ServletException {
        System.out.println("servlet init()--->初始化执行");
        super.init();
    }
}
