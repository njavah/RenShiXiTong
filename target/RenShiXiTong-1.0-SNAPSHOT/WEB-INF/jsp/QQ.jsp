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
    <script src="<%=basespath%>/js/common/jquery-1.8.0.min.js?v=1.0"></script>
    <script src="<%=basespath%>/js/font/qq.js?v=1.0"></script>
    <link rel="stylesheet" type="text/css" href="<%=basespath%>/css/frame.css?v=1.0">
</head>
<body onload="say()">

<div id="header">
    QQ网页版 ${sessionScope.loginuser}
    <%=session.getAttribute("loginuser")%>
    <input type="hidden" id="loginuser" name="loginuser" value="<%=session.getAttribute("loginuser")%>" >
    <input type="hidden" id="loginuserpattern" name="loginuserpattern" value="123" >

</div>
<div id="nav">
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
    <input type="text" id="message" onfocus="myFunction(this)" onblur="myFunction1(this)">
    <input type="button" value="发送" onmouseover="changeColor(this)" onclick="javascript:sendmessage('<%=session.getAttribute("loginuser")%>'
            ,$('#loginuserpattern').val())">
</div>

<div id="searchFriend">
    <h4>添加好友</h4>
    <br>
    <input type="text" name="searchName" id="searchName" />
    <input type="button" name="seatchButton" value="搜索Friend" onclick="searchFriend()" />
    <table id="FriendTable">
        <tr id="FirstTr"></tr>
        <tr id="FriendTr">

        </tr>
    </table>
</div>

<div id="footer">
    <input type="button" value="未读消息" onclick="nowNotReadMessage()">
    CORPYBY NIHAI
</div>
</body>
</html>
