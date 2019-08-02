<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        request.setAttribute("name", "鲁仕鑫");
        Map<String, String> map = new HashMap<>();
        map.put("map_key", "map_value");

        request.setAttribute("list_var", list);

        request.setAttribute("map_var",map);
        request.setAttribute("birthday", new Date());

        session.setAttribute("session1", "value1");
        application.setAttribute("app1", "app-value1");

        request.setAttribute("test_scope", "request_value");
        session.setAttribute("test_scope", "session_value");
        application.setAttribute("test_scope", "application_value");
    %>
            <p>
        演示 taglib 标签</p>
    <c:if test="${1==2}">
        <p>if false 演示：${false}</p>
    </c:if>

    <c:if test="${1==1}">
        <p>if true 演示：${true}</p>

    </c:if>

    <br/>
    \${ignore express language}

    <p>foreach 演示</p>
    <c:forEach var="i" begin="0" end="10" step="2">
        ${i}
    </c:forEach>

    <hr/>
    <h2>演示el表达式从域中获取值</h2>
    <p>request 对象:<strong>${requestScope.get("name")}</strong></p>
    <p>request 对象不存在:<strong>${requestScope.get("name1")}</strong></p>
    <p>seesion 对象:<strong>${requestScope.get("session1")}</strong></p>
    <p>seesion 对象不存在:<strong>${requestScope.get("session2")}</strong></p>
    <p>page 对象:<strong>${pageScope.get("session2")}</strong></p>
    <p>page 对象不存在:<strong>${pageScope.get("session2")}</strong></p>
    <p>application 对象:<strong>${pageScope.get("app1")}</strong></p>
    <p>application 对象不存在:<strong>${pageScope.get("app1")}</strong></p>

    <hr/>
    <h2>简化版本</h2>
    <p>request 对象: <strong>${name}</strong></p>
    <p>request 对象不存在: <strong>${name1}</strong></p>
    <p>seesion 对象: <strong>${session1}</strong></p>
    <p>seesion 对象不存在: <strong>${session2}</strong></p>
    <p>page 对象: <strong>${session2}</strong></p>
    <p>page 对象不存在: <strong>${session2}</strong></p>
    <p>application: <strong>${app1}</strong></p>
    <p>application 对象不存在: <strong>${app1}</strong></p>

    <p>测试变量查找路径: <strong>${test_scope}</strong></p>

    <hr/>
    <p>el 表达式获取复杂类型的数据</p>
    <p>测试复杂变量的获取  获取map: <strong>${map_var.get("map_key")}</strong></p>
    <p>测试复杂变量的获取  获取list: <strong>${list_var[1]}</strong></p>
    <p>测试复杂变量的获取  获取list: <strong>${list_var[0]}</strong></p>
    <p>测试复杂变量的获取  获取 indexoutof bound 情况: <strong>${list_var[10]}</strong></p>
    <p>测试复杂变量的获取 获取 date 数据的 getHours: <strong>${birthday.getHours()}</strong></p>
    <p>测试复杂变量的获取 获取 函数: <strong>${birthday.getHours()}</strong></p>

    <hr/>
    <p> el 表达式存储数据</p>

    <hr/>
    <p>empty 运算符号</p>
    <%
        String notempty="1234";
        String zerostring="";
        String nullstr = null;
    %>
    <c:if test="${empty notempty}">
        <p></p><c:out value="notempty值 为空" default="notempty 值不为空"></c:out></p>
    </c:if>

    <c:if test="${zerostring }">
        <p><c:out value="zerostring 为空" default="zerostring 值不为空"></c:out></p>
    </c:if>

    <c:if test="${empty nullstr }">
        <p><c:out value="nullstr 为空" default="nullstr 值不为空"></c:out></p>
    </c:if>

    <hr/>
    <p>获取其它内置对象</p>
    <p>request contextpath:${pageContext.request.contextPath}#</p>
    <p>request method: ${pageContext.request.method}#</p>
    <p>request realpath: ${pageContext.request.getRealPath("/")}#</p>
</body>
</html>
