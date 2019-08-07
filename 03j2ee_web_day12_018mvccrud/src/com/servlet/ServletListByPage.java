package com.servlet;

import com.com.dao.DaoUser;
import com.com.dao.impl.DaoUserImpl;
import com.domain.PageBean;
import com.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/users")
public class ServletListByPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("recordPerPage");

        Map<String, String[]> condition = request.getParameterMap();

        Integer curPage = currentPage == null?1:Integer.parseInt(currentPage);
        Integer recordPerPage = rows == null ?PageBean.recordPerPage:Integer.parseInt(rows);



        DaoUser dao = new DaoUserImpl();
        PageBean<User> page = dao.findUserByPage(curPage, recordPerPage, condition);

        System.out.println(page);
        request.setAttribute("pagebean", page);
        request.setAttribute("condition", condition);
        // 转发
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
