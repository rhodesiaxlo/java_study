import com.sun.deploy.net.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/demo")
public class DemoRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 网路编程中的各种参数

        // 协议  ip  端口  虚拟目录
        // url uri
        // method
        // header
        // cookie
        // referer
        //

        // 虚拟目录
        // servlet 路径



        HttpServletRequest req = request;
        req.setAttribute("reqvar1", "reqvalue1");
        req.setAttribute("reqvar2", "reqvalue2");

        req.setCharacterEncoding("utf-8");
        System.out.println("protocol: " + req.getProtocol());
        System.out.println("method: " + req.getMethod());
        System.out.println("remote address : " + req.getRemoteAddr());
        System.out.println("local address: " + req.getLocalAddr());
        System.out.println("protocol: " + req.getProtocol());
        System.out.println("local port number: " + req.getLocalPort());
        System.out.println("remote port number: " + req.getRemotePort());
        System.out.println("server port number: " + req.getServerPort());
        System.out.println("servlet path: " + req.getServletPath());
        System.out.println("context path :" + req.getContextPath());
        System.out.println("uri: " + req.getRequestURI());
        System.out.println("url: " + req.getRequestURL());

        System.out.println("===================================================");
        System.out.println("headers: ------------------------------------");
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements()) {
            String key = headers.nextElement();
            String value = req.getHeader(key);
            System.out.println(key + ": " + value);

        }

        System.out.println("===================================================");
        System.out.println("query string and parameters:-------------------");
        System.out.println(" query string:" + request.getQueryString() );


        System.out.println("===================================================");
        System.out.println("parameters map -----------------------------------");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        for (String key : keys) {
            System.out.println(key + ": "+ req.getParameter(key));
        }

//        System.out.println("===================================================");
//        System.out.println("parameters names: ---------------------------------");
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while(parameterNames.hasMoreElements()) {
//            String s = parameterNames.nextElement();
//            System.out.println(s + ": " + req.getParameter(s));
//        }

        // cookie
        System.out.println("=========================================================");
        System.out.println("cookie: -----------------------------------------------");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ", " + cookie.getValue());
        }

        System.out.println("========================================================");
        System.out.println("session:---------------------------------------------");
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while(attributeNames.hasMoreElements()) {
            String s = attributeNames.nextElement();
            System.out.println(s + ": " + session.getAttribute(s));
        }

        System.out.println("====================================================");
        System.out.println("request reader : --------------------------------");
        BufferedReader reader = req.getReader();
        String line = null;
        while((line=reader.readLine())!=null) {
            System.out.println(line);
        }

        System.out.println("=====================================================");
        System.out.println("request attribute : ----------------------");
        Enumeration<String> attributeNames1 = req.getAttributeNames();
        while(attributeNames1.hasMoreElements()) {
            String s = attributeNames1.nextElement();
            System.out.println(s + ": " + req.getAttribute(s));
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
