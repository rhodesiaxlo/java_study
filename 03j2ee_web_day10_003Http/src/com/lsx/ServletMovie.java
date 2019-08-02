package com.lsx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/movie")
public class ServletMovie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println("key = " + key +" , value = " + value);
        }

        System.out.println("======================================");
        System.out.println(" request uri = " + request.getRequestURI());
        System.out.println(" request url = " + request.getRequestURL());
        System.out.println(" method = " + request.getMethod());
        System.out.println(" version = " + request.getProtocol());
        System.out.println(" servletpath = " + request.getServletPath());
        System.out.println(" servlet name = " + request.getServerName());
        System.out.println(" servlet contxt = " + request.getServletContext());






        System.out.println(" 来源= " + request.getHeader("Referer"));
        PrintWriter writer = response.getWriter();
        writer.write("<p> success</p>");
        writer.close();

        System.out.println("abcdef");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
