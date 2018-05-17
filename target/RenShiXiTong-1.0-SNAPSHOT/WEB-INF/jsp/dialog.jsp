<%--
  Created by IntelliJ IDEA.
  User: 倪海
  Date: 2017/11/20
  Time: 21:05
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
    <title>用户聊天界面</title>
    <link rel="stylesheet" type="text/css" href="<%=basespath%>/css/dialog.css">
    <script src="<%=basespath%>/js/common/jquery-1.8.0.min.js"></script>
    <script src="<%=basespath%>/js/font/main.js?ver=1"></script>
</head>
<body>
<div id="head_1">
    我的联系人
</div>
<div id="head_2">
    聊天界面
</div>
<div id="bootom_1">
    <ul>
        <li><a href="">admin</a></li>
    </ul>
</div>
<div id="bootom_2">
    <table>
        <tr>
            <td><textarea id="area">初始化状态，没有消息</textarea></td>
        </tr>
        <tr>
            <td>
                <input type="text" name="usermessage" id="usermessage"/>
                <input type="button" onclick="send()" value="发送">
                <a href="javascript:send()">点击</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
