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
    <script src="<%=basepath%>/js/common/jquery-1.8.0.min.js?v=1.0"></script>
    <script src="<%=basepath%>/js/font/testJquery.js?v=1.0"></script>
</head>
<body>
    <table id="myTable" border="3" >
        This is table
        <tbody id="mytbody">
         This is tbody
        <tr id="myTr">
            <td>What's your name</td>
            <td>I'm LiHu</td>
            <td>How are you</td>
            <td>I'm fine Thank your</td>
            <td><input type="text" id="myText" value="今天的天气真不错"></td>
        </tr>
        <tr>
            <td>倪海</td>
            <td>计科1502班</td>
            <td>1030415230</td>
            <td>2019年</td>
        </tr>
        </tbody>

    </table>
    <input type="button" id="myButton" value="点击遍历" onclick="testJson()" />
<div id="myDiv">

</div>

</body>
</html>
