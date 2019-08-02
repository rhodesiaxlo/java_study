<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="/login" method="post">
    <c:if test="${pageContext.request.getParameter(\"error_code\")==1}">
        <p>验证码错误, 请重试</p>
    </c:if>
    <c:if test="${pageContext.request.getParameter(\"error_code\")==2}">
        <p>用户名或者密码错误, 请重试</p>
    </c:if>
    <input type="text" name="name" placeholder="请输入用户名"><br/>
    <input type="text" name="password" placeholder="请输入密码"><br/>
    <input type="text" name="captcha" placeholder=""><br/>
    <img src="/captcha" alt="captcha">
    <input type="submit" value="提交">
</form>
</body>
</html>
