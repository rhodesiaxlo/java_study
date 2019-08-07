package com.servlet;

import com.com.dao.impl.DaoUserImpl;
import com.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketTimeoutException;
import java.rmi.StubNotFoundException;
import java.util.Map;
import java.util.Set;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 登录逻辑
        // 如果成功 设置 user_id

        String captcha = request.getParameter("captcha");
        HttpSession session = request.getSession();
        String servercaptcha = (String)session.getAttribute("captcha");
        System.out.println("capt = " + captcha + " server capt = " + servercaptcha);
        System.out.println("name = " + request.getParameter("name"));
        System.out.println("password = " + request.getParameter("password"));

        if(null==captcha || !captcha.equalsIgnoreCase(servercaptcha)) {
            // 验证码不符，跳转，返回错误提示
            System.out.println("contextpath="+ request.getContextPath());
            System.out.println("captcha error");
            response.sendRedirect(request.getContextPath()+"/login.jsp?error_code=1");
            return;
        }
        System.out.println("xxxxx");

        User loginuser = new User();
        loginuser.setName(request.getParameter("name"));
        loginuser.setPassword(request.getParameter("password"));

        // 验证用户名和密码

        User user = new DaoUserImpl().userLogin(loginuser);
        System.out.println("login user = " +user);

        if(null==user) {
            System.out.println("usernamepassowrderrrorr");

            // 登录失败，跳转，返回用户名或密码错误
            response.sendRedirect(request.getContextPath()+"/login.jsp?error_code=2");
            return;
        } else {
            // 登录成功，进入 list 页面
            session.setAttribute("user_id", user.getId());

            response.sendRedirect(request.getContextPath()+"/users");
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
