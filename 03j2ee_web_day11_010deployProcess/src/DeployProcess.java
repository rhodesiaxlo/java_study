import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.SocketTimeoutException;

@WebServlet(name = "DeployProcess")
public class DeployProcess extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            // 延迟发布的过程

            // sourcecode ->  compile code -> server

            // <Context path="/02j2ee_web_day11_010deployProcess_war_exploded" docBase="F:\vbshare\java_study\02j2ee_web_day11_010deployProcess\out\artifacts\02j2ee_web_day11_010deployProcess_war_exploded" />

            // 所以在移交代码或者运行别人给的代码前需要重新编译

            System.out.println("deploy");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
