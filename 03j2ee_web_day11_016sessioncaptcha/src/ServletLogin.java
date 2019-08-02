import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 获取 captcha
        String captcha = request.getParameter("captcha");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        System.out.println("req cap = "+ captcha +" serv cap = " + request.getSession().getAttribute("captcha"));
        if(!captcha.equalsIgnoreCase(request.getSession().getAttribute("captcha").toString())) {
            request.setAttribute("error_msg","验证码错误");

            //response.sendRedirect(request.getContextPath()+"/index.jsp");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }





        // 验证用户名和密码
        // 跳转页面
        System.out.println("user login logic here ...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
