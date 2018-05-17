var oldstr = "";
var oldstr1 = "";
var oldn ;
function getmessageOne(str,str1) {
    if(str!=oldstr||str1!=oldstr1){
        if(oldstr!=""){
            alert("暂停了oldn="+oldn)
            clearInterval(oldn);
        }
    }
    oldstr = str;
    oldstr1 = str1;
    oldn = setInterval(getmessage(str,str1),3000);
    alert(oldn);
}
function getmessage(str,str1) {
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
    if($("#myul li").length==0){
        $.ajax({
            url:"/QQ/getperson",
            success:function (data) {
             //   alert(data);
                var s = data.split(',');
            //    alert(s);
                for(var i=0;i<s.length;i++){
               //     alert(s[i]);
                    s[i] = s[i].trim();
                    var ss = 'javascript:getmessageOne('+"'"+str+"'"+','+"'"+s[i]+"'"+')';
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
  //  alert(textarea);
    var message = $("#message").val();
  //  alert(message);
    textarea=textarea+"\n"+str+":"+message;
    $("#textarea").val(textarea)
    $("#message").val("");
    $.ajax({
        url:"/QQ/updatecontext",
        error:function (data) {
            alert("发送失败:"+data);
        },
        success:function (data) {
            alert("发送成功"+data);
        },
        data:{context:textarea,name1:str,name2:str1},
    })
}

function init() {
    alert("页面正在加载");
}
function say() {
   // alert("页面正在加载");
}

$(document).ready(function () {
  //  alert("这是ready方法");
})


function changeColor(object) {
    object.value("提交了");
}
function testsql() {
    var id=$("#textid").val();
    $.ajax({
        url:"/QQ/information",
        success:function (data) {
           $("#texttable tr").remove();
               var jsonobj = eval('('+data+')');
               if(jsonobj.length>0){
                   $("#texttable").append('<tr><td>ID</td><td>UserName</td>');
               }
               for(var i=0;i<jsonobj.length;i++){
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
function myFunction(x)
{
    x.style.background="yellow";
}

function myFunction1(x) {
    x.style.background="white";
}

function searchFriend() {
    var searchName = $("#searchName").val();
    alert("你查询的好友名字为:"+searchName);

    $.ajax({
            url:"/QQ/getPersonByName",
            dataType:"text",
            success:function (data) {
                $("#FriendTr").empty();

                if(data==""){
                    $("#FriendTr").append("<td>"+"该用户不存在"+"</td>");
                }
                else{
                    $("#FriendTr").append("<td>"+data+"</td>");
                    $("#FriendTr").append("<td>"+"<input type='button' onclick=addPerson() value='添加'/>"+"</td>");
                }
            },
            error:function(){
                alert("查询失败");
            },
           data:{Name:searchName}
    } )
}

function addPerson() {
    var searchName = $("#FriendTr").text();
    var searchName1 = $("#loginuser").val();
    var isFriend = false;
    $.ajax({
        url: "/QQ/getperson",
        success: function (data) {
            //   alert(data);
            var s = data.split(',');
            //    alert(s);
            for (var i = 0; i < s.length; i++) {
                //     alert(s[i]);
                s[i] = s[i].trim();
                if(s[i]==searchName){
                    alert(searchName+"已经是你的好友了");
                    isFriend = true;
                    break;
                }
            }
        },
        error:function () {
            alert("查询失败");
        },
        data:{username:searchName1}
    });
    alert("isFriend的值为:"+isFriend);
    if(!isFriend){
        alert("执行添加好友方法:"+$("#FriendTr").text()+"  "+searchName1);
        $.ajax({
            url: "/QQ/addFriendByName",
            success: function () {
                alert("添加成功");
                showperson(searchName1);
                $("#FriendTr").empty();
            },
            error: function () {
                alert("添加失败");
            },
            data:{searchName1:searchName,searchName2:searchName1}
        })
    }


}

function nowNotReadMessage() {
    var loginName = $("#loginuser").val();
    $.ajax({
        url: "/QQ/nowNotReadMessage",
        success: function (data) {

            alert(data);
            var obj = JSON.parse(data);
            alert(obj);
            alert(obj.namelist[0].name);
            var list = $("#myul").children();
            for(var i=0;i<list.length;i++){
                alert(list.eq(i).text());
            }
        },
        error: function () {
            alert("失败");
        },
        data:{name:loginName}
    })
}



