package com.servlet;

import com.com.dao.DaoUser;
import com.com.dao.impl.DaoUserImpl;
import com.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/deluser")
public class ServletDel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = new User();
        try {
            BeanUtils.populate(u, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        boolean b = new DaoUserImpl().delUser(u);

        if(!b) {

        } else {
            response.sendRedirect(request.getContextPath()+"/users");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
