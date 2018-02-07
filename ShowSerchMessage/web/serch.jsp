<%--
  Created by IntelliJ IDEA.
  User: 倪海
  Date: 2017/11/25
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path =application.getContextPath();
  String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
  <head>
    <title>百度一下</title>
    <script src="<%=basepath%>/js/common/jquery-1.8.0.min.js"></script>
    <style type="text/css">
      #mydiv{
        position: absolute;
        left:50%;
        top:50%;
        margin-left: -200px;
        margin-top: -50px;
      }
    </style>
    <script type="text/javascript">
      var xmlhttp = null;
      function  getMoreContext() {
          var context = document.getElementById("serchcontext").value;
        alert(context);
        if(context==""){
            return;
        }
        if(window.XMLHttpRequest){
            xmlhttp = new XMLHttpRequest();
        }
        else{
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        var url = "serch"
        xmlhttp.open("POST",url,true);
        xmlhttp.onreadystatechange=function () {
            if(xmlhttp.readyState==4 && xmlhttp.status==200){
                var resultcontext = xmlhttp.responseText;
                alert(resultcontext);
                var json = JSON.parse(resultcontext);

                document.getElementById("resultcontext").value=json;
            }
        }
        xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        xmlhttp.send("keyword="+context);

      }
      function loadtest() {
          alert("hellow");
          $("#resultcontext").load('');
      }
    </script>
  </head>
  <body>
    <div id="mydiv">
      <input type="text" name="serchcontext" id="serchcontext" onkeyup="getMoreContext()"/>
      <input type="button" value="百度一下" onclick="loadtest()">
      <input type="text" id="resultcontext" />
      <a href="text">点击</a>
    </div>
  </body>
</html>
