package com.lsx;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo")
public class Servlet1 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init 执行了。。。");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getservletconfig 执行了。。。");

        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("service99 执行了。。。");


    }

    @Override
    public String getServletInfo() {
        System.out.println("getservletinfo 执行了。。。");

        return null;
    }

    @Override
    public void destroy() {

        System.out.println("destory 执行了。。。");


    }
}

