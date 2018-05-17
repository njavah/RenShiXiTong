<%--
  Created by IntelliJ IDEA.
  User: 倪海
  Date: 2017/11/17
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=application.getContextPath();
    String basespath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
            +path+"/";
%>
<html>
<head>
    <title>登陆</title>
    <script src="<%=basespath%>/js/common/jquery-1.8.0.min.js"></script>
    <script src="<%=basespath%>/js/font/qq.js"></script>
    <style type="text/css">
        #mydiv{
            position: absolute;
            left:50%;
            top:50%;
            margin-left: -200px;
            margin-top: -50px;
        }
    </style>
</head>
<body>
<div id="serchid">
    <form>
        <input type="text" id="textid" name="textid" size="100" />
        <input type="button" id="textbutton" value="查询" onclick="javascript:testsql()"/>
        <table id="texttable">

        </table>
    </form>
</div>
<div id="mydiv">
    <form action="/user/login" method="post">
        <font color="red">${sessionScope.message}</font>
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username"/> </td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password"/> </td>
            </tr>
            <tr>
                <td><input type="submit" value="登陆"/> </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
