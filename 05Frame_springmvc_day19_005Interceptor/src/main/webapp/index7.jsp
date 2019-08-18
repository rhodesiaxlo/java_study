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
<h1>演示 request_scope session_scope</h1>
<!-- 演示封装为实体-->
<form action="${pageContext.request.contextPath}/param/ses" >
    <input type="text" name="name" placeholder="请输入姓名">
    <input type="text" name="password" placeholder="请输入密码">
    <input type="text" name="date" placeholder="请输入日期">

    <input type="submit" value="提交">
</form>
</body>
</html>