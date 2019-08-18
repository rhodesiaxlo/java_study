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
<h1>演示 集合封装</h1>
<!-- 演示封装为实体-->
<form action="${pageContext.request.contextPath}/param/col" >
    <input type="text" name="name" placeholder="请输入姓名">
    <input type="text" name="password" placeholder="请输入密码">
    <input type="text" name="account.money" placeholder="请输入账户金额">
    <input type="text" name="lst[0]" value="" placeholder="请输入集合元素1">
    <input type="text" name="lst[1]" value="" placeholder="请输入集合元素2">
    <input type="text" name="map['one']" value="" placeholder="请输入map one 键值">
    <input type="text" name="map['two']" value="" placeholder="请输入map two 键值">
    <input type="submit" value="提交">
</form>
</body>
</html>