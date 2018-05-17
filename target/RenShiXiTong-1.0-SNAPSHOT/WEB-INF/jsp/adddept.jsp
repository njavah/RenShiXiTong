<%--
  Created by IntelliJ IDEA.
  User: 倪海
  Date: 2017/11/22
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=application.getContextPath();
    String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+
    "/";
%>
<html>
<head>
    <title>添加部门</title>
    <script src="${basepath}/js/common/jquery-1.8.0.min.js"></script>
    <script src="${basepath}/js/font/main.js?ver=1"></script>

</head>
<body>
${basepath}
    <form action="/dept/adddept" method="post">
        <table>
            <tr>
                <td>部门名称:</td>
                <td><input type="text" name="deptname" id="deptname" /></td>
                <td>详细描述:</td>
                <td><input type="text" name="deptdescription" id="deptdescription" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="添加"/></td>
                <td><input type="button" value="取消" onclick="quit()" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
