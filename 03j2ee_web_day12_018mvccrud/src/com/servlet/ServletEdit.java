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

@WebServlet("/edituser")
public class ServletEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User u = new User();
        try {
            BeanUtils.populate(u, request.getParameterMap());
            boolean b = new DaoUserImpl().updateUser(u);
            if(b) {
                response.sendRedirect(request.getContextPath()+"/users");
            } else {
                // 更新出错。。
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("保存出错");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = new DaoUserImpl().findById(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("user", u);

        request.getRequestDispatcher("edit.jsp").forward(request,response);

    }
}
