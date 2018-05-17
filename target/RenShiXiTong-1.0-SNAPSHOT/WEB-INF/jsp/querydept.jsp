<%--
  Created by IntelliJ IDEA.
  User: 倪海
  Date: 2017/11/19
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门查询</title>
</head>
<body>
<form action="/dept/querydept" method="post">
    <table border="0">
        <tr>
            <td>部门名称:</td>
            <td><input type="text" name="name" /></td>
            <td><input type="submit" value="查询"/></td>
        </tr>
        <c:if test="${deptlist!=null}">
            <tr>
                <td>部门名称</td>
                <td>部门描述</td>
            </tr>
        </c:if>
        <c:forEach items="${deptlist}" var="dept" varStatus="status">
            <tr>
                <td>${dept.deptname}</td>
                <td>${dept.deptdescription}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
