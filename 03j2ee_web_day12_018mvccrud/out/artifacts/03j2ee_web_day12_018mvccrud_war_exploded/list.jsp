<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>列表页面</title>
</head>
<body>
<!-- 查询form-->
<div align="right">
    <form action="${pageContext.request.contextPath}/users" method="get">
        <span>姓名:<input type="text" name="name" value=""></span><br/>
        <input type="submit" value="查询">
    </form>

</div>

<div align="right">
    <a href="${pageContext.request.contextPath}/new.jsp">新建对象</a>
</div>

<table border="1px;solid" align="center">
    <tr>
        <td>选择</td>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>生日</td>
        <td>操作</td>
    </tr>
    <tbody>
        <c:forEach items="${users}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birthday}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/edituser?id=${user.id}">编辑</a>
                    <a href="${pageContext.request.contextPath}/deluser?id=${user.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
