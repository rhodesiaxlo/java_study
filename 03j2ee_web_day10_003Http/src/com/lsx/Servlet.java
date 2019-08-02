package com.lsx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
//        PrintWriter writer = response.getWriter();
//        writer.write("<a href='/03j2ee_web_day10_003Http_war_exploded/movie' alt='url' >link</a>");
//        writer.close();




//        System.out.println("demo page");
        //request.getRequestDispatcher("movie").forward(request, response);
        HttpSession session = request.getSession();
        session.setAttribute("session name ", "1234");
        response.addCookie(new Cookie("name", "value"));


        response.sendRedirect("/03j2ee_web_day10_003Http_war_exploded/movie");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
