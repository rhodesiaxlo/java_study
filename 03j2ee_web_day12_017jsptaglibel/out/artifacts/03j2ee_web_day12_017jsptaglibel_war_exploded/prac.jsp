<%@ page import="java.util.List" %>
<%@ page import="com.lsx.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p> 展示数据示例</p>
<%
    List<User> list = new ArrayList<>();
    list.add(new User("张三", 20, new Date()));
    list.add(new User("张三", 20, new Date()));
    list.add(new User("张三", 20, new Date()));
    list.add(new User("张三", 20, new Date()));
    request.setAttribute("list", list);
%>

<table border="1px;solid" align="center">
    <thead>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>生日</td>
    </thead>
    <tbody>

        <c:forEach items="${list}" var="user" varStatus="s">
            <tr <c:if test="${s.count % 2 == 0}"> bgcolor="red"</c:if>>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.bir()}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
