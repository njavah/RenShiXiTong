function searchTable() {
    alert("ffdfd");
    var tableD = $("#myTable");
    var list = $("#myTable").children();
    $("#mytbody").each(function (a,b) {
        alert($(b).text())
    })
     //$("#mytbody").children().eq(0).css("background-color","yellow");
}

function testJson(){
   var obj = {
       "namelist":[{"name":"zhangsan","num":"2"},{"name":"lisi","num":"23"}]
   };
   alert(obj.namelist[0].name);
   alert(obj.namelist[1].name);
   alert(obj.namelist.length);

}