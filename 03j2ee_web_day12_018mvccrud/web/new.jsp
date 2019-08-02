<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/newuser" method="post">
        <input type="text" name="name" placeholder="请输入用户名"><br/>
        <input type="text" name="password" placeholder="请输入密码"><br/>
        <input type="text" name="age" placeholder="年龄"><br/>
        <input type="submit" value="提交">

    </form>
</body>
</html>
