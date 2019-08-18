<%--
  Created by IntelliJ IDEA.
  User: rho
  Date: 2019-08-14
  Time: 00:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page  isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<P> 演示参数传递</P>
<form action="${pageContext.request.contextPath}/param/single" >
    <input type="text" name="name" placeholder="请输入姓名">
    <input type="text" name="password" placeholder="请输入密码">
    <input type="submit" value="提交">
</form>
</body>
</html>