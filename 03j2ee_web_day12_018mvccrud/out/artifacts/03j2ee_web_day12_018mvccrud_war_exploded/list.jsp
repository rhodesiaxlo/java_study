<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>列表页面</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <H1 align="center">用户信息列表页面</H1>
    <%@include file="header.jsp"%>

<form class="form-inline" style="float:left" action="${pageContext.request.contextPath}/users" method="get">
    <div class="form-group">
        <label for="name">姓名: </label>
        <input type="text" class="form-control" name="name" id="name"  value="${condition.get("name")[0]}" >
    </div>
    <div class="form-group">
        <label for="birthday">生日: </label>
        <input type="text" class="form-control" name="birthday" id="birthday" value="${condition.get("age")[0]}">
    </div>
    <button type="submit" class="btn btn-default">查询</button>
</form>

<div style="float:right">
<a class="btn btn-primary" href="${pageContext.request.contextPath}/new.jsp">新建</a>
<a class="btn btn-primary" id="delSelect" href="javascript:void(0);" >删除选中</a>
</div>

<form action="${pageContext.request.contextPath}/deluser" method="post" id="delform">
    <table class="table table-striped table-hover table-bordered ">
    <tr class="table-success">
        <td>选择</td>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>生日</td>
        <td>操作</td>
    </tr>
    <tbody>
        <c:forEach items="${pagebean.list}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox" name="uid" value="${user.id}"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birthday}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/edituser?id=${user.id}">编辑</a>
<%--                    <a href="${pageContext.request.contextPath}/deluser?id=${user.id}">删除</a>--%>
                    <a href="javascript:del(${user.id})">删除</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</form>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" href="/users?currentPage=1&name=${condition.name[0]}&birthday=${condition.birthday[0]}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
            </a>
        </li>

        <c:forEach var="i" begin="1" end="${pagebean.pageTotal}" step="1">
            <c:if test="${pagebean.current == i}">
                <li  class="page-item  active"><a class="page-link" href="/users?currentPage=${i}&name=${condition.name[0]}&birthday=${condition.birthday[0]}">${i}</a></li>
            </c:if>
            <c:if test="${pagebean.current != i}">
                <li  class="page-item "><a class="page-link" href="/users?currentPage=${i}&name=${condition.name[0]}&birthday=${condition.birthday[0]}">${i}</a></li>
            </c:if>


        </c:forEach>


        <li class="page-item">
            <a class="page-link" href="/users?currentPage={$pagebean.pageTotal}&name=${condition.name[0]}&birthday=${condition.birthday[0]}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Next</span>
            </a>
        </li>
    </ul>
</nav>
    共 ${pagebean.recordTotal}条结果，分 ${pagebean.pageTotal} 页

<script src="js/jquery-3.4.1.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</div>
</body>
<script>
    // 确认删除
    function del(id) {
        if(confirm("确认删除吗?")) {
            location.href = "${pageContext.request.contextPath}/deluser?id=${user.id}";
        }
    }
    window.onload = function() {
        document.getElementById("delSelect").onclick = function() {
            document.getElementById("delform").submit();
        }
    }
</script>
</html>
