import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class comlsxDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        ServletContext context1 = request.getServletContext();
        ServletContext context2 = this.getServletContext();

        System.out.println(context1==context2);

        // mima 文件类型
        // extension 和 mima 类型有对应关系

        String mimeType = context1.getMimeType("1.jpg");
        System.out.println("mime type = " + mimeType);

        // 域对象
        // context1.setAttribute();
        context1.setAttribute("appscope", 1);

        context1.setAttribute("realpath", context1.getRealPath("/index.jsp"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
