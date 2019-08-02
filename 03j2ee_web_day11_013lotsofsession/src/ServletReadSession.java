import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/readsession")
public class ServletReadSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context1 = request.getServletContext();
        String realPath = context1.getRealPath("/");


        long l = System.currentTimeMillis();
        List<BufferedReader> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            // 创建文件，每一个写入a
            BufferedReader reader = new BufferedReader(new FileReader(realPath + File.separator+"rep"+ File.separator+ i + ".txt"));
            list.add(reader);

            String s = reader.readLine();
            System.out.println(s);


        }

        System.out.println(System.currentTimeMillis()-l);
        System.out.println("list= "  + list.size());
        response.getWriter().write("success");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
