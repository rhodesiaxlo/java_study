package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/*")
public class FilterLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 排除 login.jsp
        HttpServletRequest req2 = (HttpServletRequest)req;
        String requestURI = req2.getRequestURI();

        if(requestURI.contains("login")||requestURI.contains("captcha")) {
            HttpSession session = req2.getSession();
            Object user_id = session.getAttribute("user_id");
            if(null!=user_id) {
                ((HttpServletResponse) resp).sendRedirect(req2.getContextPath()+"/users");
            }

            // 静态资源
        } else if(requestURI.contains("css") || requestURI.contains("js") || requestURI.contains("image")) {
            chain.doFilter(req, resp);
            return;
        }else {
            // 检查登录信息
            HttpSession session = req2.getSession();
            Object user_id = session.getAttribute("user_id");
            if(null==user_id) {
                // 跳转到登录页面
                HttpServletResponse response = (HttpServletResponse)resp;
                ((HttpServletResponse) resp).sendRedirect(req2.getContextPath()+"/login.jsp");
                return;
            }

        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
