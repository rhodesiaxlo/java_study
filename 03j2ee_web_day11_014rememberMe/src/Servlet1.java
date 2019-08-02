import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if(null==cookies||cookies.length<1) {
            // 第一次登陆
            firstLogin(request, response);
        } else {
            // 查询 cookie 检查是否存在last_time字段
            for (Cookie cookie : cookies) {
                if("last_time".equals(cookie.getName())) {
                    // 存在，跳转到显示页面

                    String last_time = cookie.getValue();


                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                    String format = df.format(new Date());
                    cookie.setValue(format);
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);

                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().write("last_time" + last_time);
                    return;

                }


            }
            // 不存在 设置 cookie,显示欢迎首次访问
            firstLogin(request, response);

        }
    }

    private void firstLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String format = df.format(new Date());
        Cookie cookie = new Cookie("last_time", format);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        response.setContentType("text/html;charset=utf-8");

        response.getWriter().write("欢迎首次登录");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
