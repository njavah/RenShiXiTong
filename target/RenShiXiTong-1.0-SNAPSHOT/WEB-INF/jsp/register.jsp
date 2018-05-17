<%--
  Created by IntelliJ IDEA.
  User: 倪海
  Date: 2018/5/17
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <form method="post" action="/QQ/register">
        <table>
            <tbody>
            <tr>
                <td>用户名:</td>
                <td><input type="text" id="registerName"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" id="registerPassword"/></td>
            </tr>
            <tr>
                <td>确认密码:</td>
                <td><input type="password" id="registerPasswordAgain"/></td>
            </tr>
            <tr>
                <td>真实姓名:</td>
                <td><input type="text" id="realName"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="注册"/></td>
            </tr>
            </tbody>
        </table>
    </form>

</body>
</html>
