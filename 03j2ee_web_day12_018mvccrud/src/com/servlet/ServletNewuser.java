package com.servlet;

import com.com.dao.impl.DaoUserImpl;
import com.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/newuser")
public class ServletNewuser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        // 创建新用户
        User u = new User();
        try {
            BeanUtils.populate(u, request.getParameterMap());

            System.out.println("new user = " + u);
            boolean isSuccess = new DaoUserImpl().createUser(u);

            if(!isSuccess) {
                System.out.println("创建失败");
            } else {
                response.sendRedirect(request.getContextPath()+"/users");
            }



        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
