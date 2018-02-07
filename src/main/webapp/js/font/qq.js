function getmessage(str,str1) {
  /*  $("#messagecontext").load("/QQ/getmessage",{username1:str,username2:str1});

    $("#textarea").val("sfsf");*/
  /*  $.get("/QQ/getmessage",{username1:str,username2:str1},function (data) {
        alert(data);
        $("#messagecontext").val(data);
    })*/
    $.ajax({
        url:"/QQ/getmessage",
        success:function (data) {
            /*alert(data);*/
            $("#textarea").val(data);
            $("#loginuserpattern").val(str1);
           /* alert($("#loginuserpattern").val());*/
        },
        error:function () {
            alert("错误");
        },
        data:{username1:str,username2:str1},
    })
}

function showperson(str) {
alert("进入了联系人模块");
alert($("#loginuserpattern").val());
    if($("#myul li").length==0){
        alert("进入了")
        $.ajax({
            url:"/QQ/getperson",
            success:function (data) {
                alert(data);
                var s = data.split(',');
                alert(s);
                for(var i=0;i<s.length;i++){
                    alert(s[i]);
                    s[i] = s[i].trim();
                    var ss = 'javascript:getmessage('+"'"+str+"'"+','+"'"+s[i]+"'"+')';
                    $("#myul").append("<li><a href="+ss+">"+s[i]+"</a></li>");
                }
                /*            $("#textarea").val(data);*/
            },
            error:function () {
                alert("错误");
            },
            data:{username:str},
        })
    }
    else {
        $("#" + str + " li").remove();
    }
}

function sendmessage(str,str1) {
    var textarea =  $("#textarea").val();
    alert(textarea);
    var message = $("#message").val();
    alert(message);
    textarea=textarea+"\n"+str+":"+message;
    $("#textarea").val(textarea)
    $("#message").val("");
    $.ajax({
        url:"/QQ/updatecontext",
        error:function () {
            alert("发送失败");
        },
        success:function () {
            alert("发送成功");
        },
        data:{context:textarea,name1:str,name2:str1},
    })
}

function say() {
    alert("hello");
}


function testsql() {
    var id=$("#textid").val();
    alert("进入了testsql"+id);
    $.ajax({
        url:"/QQ/information",
        success:function (data) {
            alert("接下来显示后台传出来的数据");
           alert(data);
           $("#texttable tr").remove();
               var jsonobj = eval('('+data+')');
               if(jsonobj.length>0){
                   $("#texttable").append('<tr><td>ID</td><td>UserName</td>');
               }
               for(var i=0;i<jsonobj.length;i++){
                   alert("id:"+jsonobj[i].id+"  username:"+jsonobj[i].username);
                   $("#texttable").append('<tr><td>'+jsonobj[i].id+'</td><td>'+jsonobj[i].username+'</td>');
               }


        },
        error:function () {
            alert("错误");
        },
        data:{serchid:id},
    })
}
/*
setInterval("say()","1000");*/
