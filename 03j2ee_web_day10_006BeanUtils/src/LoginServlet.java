import com.Dao.UserDao;
import com.Dao.impl.UserDaoImpl;
import com.Domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码字符集
        request.setCharacterEncoding("utf-8");

        // 获取请求参数
        UserDao dao = new UserDaoImpl();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("name = " + name +", password=" +password);
        User user1 = new User();
        try {
            BeanUtils.populate(user1, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        User user = dao.userLogin(user1);

        System.out.println(user);
        // 跳转页面
        if(null == user) {
            request.getRequestDispatcher("loginfailed").forward(request, response);
        } else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("loginsuccess").forward(request, response);
        }


        //
        //response.setStatus();
        //response.setContentType();
        //response.setHeader();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
