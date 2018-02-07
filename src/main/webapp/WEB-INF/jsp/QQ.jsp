<%--
  Created by IntelliJ IDEA.
  User: 倪海
  Date: 2017/11/17
  Time: 15:33
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
    <title>QQ</title>
    <script src="<%=basespath%>/js/common/jquery-1.8.0.min.js"></script>
    <script src="<%=basespath%>/js/font/qq.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basespath%>/css/frame.css?v=1.0">
</head>
<body>

<div id="header">
    QQ网页版 ${sessionScope.loginuser}
    <%=session.getAttribute("loginuser")%>
    <input type="hidden" id="loginuser" name="loginuser" value="<%=session.getAttribute("loginuser")%>" >
    <input type="hidden" id="loginuserpattern" name="loginuserpattern" value="123" >

</div>
<div id="nav">
    <a href="javascript:say()">点击我sayhello</a>
    <br>
  <a href="javascript:showperson('<%=session.getAttribute("loginuser")%>')">联系人</a>
    <ul id="myul">
    </ul>
</div>

<div id="section">
    <div id="messagecontext">

    </div>
    <textarea id="textarea" cols="80" rows="20">
        这里应该显示聊天记录
    </textarea>
    <br>
    <input type="text" id="message">
    <input type="button" value="发送" onclick="javascript:sendmessage('<%=session.getAttribute("loginuser")%>'
            ,$('#loginuserpattern').val())">
</div>

<div id="footer">
    CORPYBY NIHAI
</div>
</body>
</html>
