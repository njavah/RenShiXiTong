function show(str,str1,str2,str3,str4) {
/*    alert("world");
    alert(str3);*/
    var str3_1 = "'"+str3+"'";
    var str4_1 = "'"+str4+"'";
/*    alert(str3_1);*/
    var methond = 'javascript:change('+str3_1+')';
    var methond1 = 'javascript:change('+str4_1+')';
/*    alert("world"+methond);*/
    if($("#"+str+" li").length==0){
        $("#"+str+"").append("<li><a href="+methond+">"+str1+"</a></li>");
        $("#"+str+"").append("<li><a href="+methond1+">"+str2+"</a></li>");
    }
    else {
        $("#" + str + " li").remove();
    }

}

function change(str) {
/*    alert(str);*/
    $("#change").attr("src",str);
}

function send() {
    alert("send()");
    $("#area").val("hahah");
    $("#usermessage").val("修改");
    alert("到这");
    $("#area").innerText="hahahahhaha";
}

function quit() {
    alert("hello");
    $("#deptdescription").val("");
    $("#deptname").val("");
}

function test() {
    alert("hello");
    alert("222");
    /*$("#text").val("hellow");
    $("#testdiv").load("/test/t1/hello","user=admin",function () {
        alert("这是回调函数");
    });
    $("#asd").load("/test/t1/hello",function () {
        alert("这是回调函数");
    });
    $("#testdiv_1").load("/index.jsp");
    alert("world");
    $.get("/index.jsp",{Action:"get",Name:"lulu"},function (data) {
        alert(data);
    })
    alert("结束get");
    $.post("/test.jsp", { Action: "post", Name: "lulu" },

        function (data1){

// data 可以是 xmlDoc, jsonObj, html, text, 等等.
//this; // 这个Ajax请求的选项配置信息，请参考jQuery.get()说到的this
            alert(data1);

        });
    alert("结束post");
    alert("开始ajax方法")
    $.ajax({
        url:"/test/t1/hello",
        type:"get",
        success:function (data2) {
            alert(data2);
        },
        error:function () {
            alert("出错");
        }
    })
    alert("结束ajax方法");*/
    $("#testdiv").load("/adduser");
}