import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("===============servlet 1============================");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ": " + cookie.getValue());
        }

         Cookie cookie1 = new Cookie("server-cookie", "servervalue");
        // Cookie cookie2 = new Cookie("server-cookie2", "servervalue2");
//        Cookie cookie3 = new Cookie("server-cookie3", "servervalue3");
//        Cookie cookie4 = new Cookie("server-cookie4", "servervalue4");
//
        cookie1.setMaxAge(10000);
        response.addCookie(cookie1);
//        response.addCookie(cookie4);
        response.sendRedirect(request.getContextPath()+"/servlet2");
        // request.getRequestDispatcher("/servlet2").forward(request, response);
        //response.getWriter().write("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
