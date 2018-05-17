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
    <title>人事管理系统</title>
    <script src="<%=basespath%>/js/common/jquery-1.8.0.min.js"></script>
    <script src="<%=basespath%>/js/font/main.js?ver=1"></script>
    <link rel="stylesheet" type="text/css" href="<%=basespath%>/css/frame.css?v=1.0">
</head>
<body>

 <div id="header"> 登陆成功，欢迎用户${sessionScope.username}</div>
<div id="nav">
    <ul>
        <li><a href="javascript:show('usermanger','添加用户','用户查询','/adduser','/queryuser')">用户管理</a>
            <ul id="usermanger"></ul>
        </li>
        <li><a href="javascript:show('bumenmanger','添加部门','部门查询','/adddept','/querydept')">部门管理</a>
            <ul id="bumenmanger"></ul>
        </li>
        <li><a href="javascript:show('zhiweimanger','添加职位','职位查询')">职位管理</a>
            <ul id="zhiweimanger"></ul>
        </li>
        <li><a href="javascript:show('yuangongmanger','添加员工','员工查询')">员工管理</a>
            <ul id="yuangongmanger"></ul>
        </li>
        <li><a href="javascript:show('gonggaomanger','添加公告','公告查询')">公告管理</a>
            <ul id="gonggaomanger"></ul>
        </li>
        <li><a href="javascript:show('xiazaimanger','文档查询','上传文档')">下载中心</a>
            <ul id="xiazaimanger"></ul>
        </li>
    </ul>
</div>

<div id="section">
    <iframe src="/image/1.jpg" id="change" frameborder="0" width="700" height="350"></iframe>
</div>
<div id="footer">Copyright nihai</div>
</body>
</html>
