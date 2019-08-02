import com.Domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginsuccess")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码字符集


        // 获取请求域属性
        User user = (User)request.getAttribute("user");
        System.out.println("success: " +user);

        // 响应
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();


        writer.write("登录成功！欢迎你," + user.getName());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
