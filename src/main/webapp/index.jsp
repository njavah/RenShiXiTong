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
可以返回当前页面所在的应用的名字:${path}
basepath:${basepath}
<a href="loginform">点击进入登陆界面</a>
<div>
    <a href="test.jsp" target="hellow">点击一下</a>
</div>
<div>
    <iframe name="hellow" src=" " ></iframe>
</div>
</body>
</html>
