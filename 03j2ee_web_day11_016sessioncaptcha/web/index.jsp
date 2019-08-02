<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <% if(null!=request.getAttribute("error_msg")) { %>
  <p color="red"><%=request.getAttribute("error_msg")%></p>
  <% } %>
  <form action="/login" method="post">
    <input type="text" name="name" placeholder="请输入姓名"><br/>
    <input type="text" name="password" placeholder="请输入密码"><br/>
    <img src="/captcha" alt="captcha"><input type="text" name="captcha">
    <input type="submit" value="提交">
  </form>
  </body>
</html>
