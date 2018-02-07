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
    <title>用户查询</title>
</head>
<body>
    <form action="/user/queryuser" method="post">
        <table border="0">
            <tr>
                <td>真实姓名:</td>
                <td><input type="text" name="name" /></td>
                <td></td>
                <td>用户名:</td>
                <td><input type="text" name="username" /></td>
                <td></td>
                <td><input type="submit" value="查询"/></td>
            </tr>
            <c:if test="${loginuserList!=null}">
                <tr>
                    <td>用户名</td>
                    <td>真实姓名</td>
                </tr>
            </c:if>
            <c:forEach items="${loginuserList}" var="loginuser" varStatus="status">
                <tr>
                    <td>${loginuser.username}</td>
                    <td>${loginuser.name}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
