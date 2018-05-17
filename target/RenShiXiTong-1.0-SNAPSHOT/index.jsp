<%--
  Created by IntelliJ IDEA.
  User: 倪海
  Date: 2017/11/16
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path=application.getContextPath();
    String basespath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
            +path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="loginform">点击进入QQ网页版登陆界面</a>
<a href="main">点击进入人事管理系统</a>
</body>
</html>
