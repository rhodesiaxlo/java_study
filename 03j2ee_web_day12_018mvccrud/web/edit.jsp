<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/edituser" method="post">
    <input type="hidden" name="id" value="${user.id}"><br/>
    <input type="text" name="name" value="${user.name}"><br/>
    <input type="text" name="password" value="${user.password}"><br/>
    <input type="text" name="age" value="${user.age}"><br/>
    <input type="submit" value="提交">

</form>
</body>
</html>
