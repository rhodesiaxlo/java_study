<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--
    <% out.write("aaaaaaa"); %>
   123

  <p>hell world</p>
  --%>

  <% out.write("1234");
    String realPath = application.getRealPath("/");

    System.out.println(page);
    System.out.println(request);
    System.out.println(session);
    System.out.println(out);
    System.out.println(response);


  %>
  </body>
</html>

