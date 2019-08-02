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
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/users")
public class ServletList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询数据 // 模糊查询
        String name = request.getParameter("name");
        List<User> users = null;
        if(null!=name) {
            // 根据姓名模糊查询
            users = new DaoUserImpl().findByName(name);

        } else {

            User u = new User();
            // 获取查询条件，beanutils
            try {
                BeanUtils.populate(u, request.getParameterMap());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            // 查询
            DaoUser dao = new DaoUserImpl();
            users = dao.getUsers();
        }

        request.setAttribute("users", users);
        request.getRequestDispatcher("list.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
