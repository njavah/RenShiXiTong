<%--
  Created by IntelliJ IDEA.
  User: 倪海
  Date: 2017/11/18
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
    <form action="/user/adduser" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>确认密码:</td>
                <td><input type="password" name="secondpassword"></td>
            </tr>
            <tr>
                <td>真实姓名:</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="添加用户"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
