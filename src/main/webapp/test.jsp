<%--
  Created by IntelliJ IDEA.
  User: 倪海
  Date: 2017/11/19
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = application.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <script src="<%=basepath%>/js/common/jquery-1.8.0.min.js"></script>
    <script src="<%=basepath%>/js/font/main.js"></script>
</head>
<body>
This is test page
<a href="javascript:test()">点击</a>


<div id="testdiv">

</div>


</body>
</html>
