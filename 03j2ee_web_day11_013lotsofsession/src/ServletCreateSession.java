import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@WebServlet("/createsession")
public class ServletCreateSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context1 = request.getServletContext();
        String realPath = context1.getRealPath("/");



        for (int i = 0; i < 1000000; i++) {
            // 创建文件，每一个写入a
            BufferedWriter w = new BufferedWriter( new FileWriter(realPath + File.separator+"rep"+ File.separator +i+".txt"));
            w.write("wo shi ce shi hang");
            w.close();

        }

        response.getWriter().write("success");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
