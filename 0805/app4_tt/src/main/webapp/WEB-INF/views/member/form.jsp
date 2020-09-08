<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.example.app2.model.join.MemberType"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#btn1").click(function(){
	var id = $("#id").val();
    $.post("/member/idCheck",
    {
      id: id
    },
    function(data,status){
    	if(status=="success"){
    		var html = "중복된 아이디";
    		var res = $.parseJSON(data);
    		if(res.flag==true){
    			html = "사용가능한 아이디";
    		}
    		$("#idCheck").html(html)
    	}
      //alert("Data: " + data + "\nStatus: " + status);
    });
  });
});
</script>
</head>
<body>
<h3>join form</h3>
<form action="/member" method="post">
id:<input id="id" type="text" name="id">
<input type="button" id="btn1" value="id check"><span id="idCheck"></span><br>
pwd:<input type="text" name="pwd"><br>
name:<input type="text" name="name"><br>
email:<input type="text" name="email"><br>
member type:<input name="type" type="radio" value="${MemberType.CONSUMER}" checked>${MemberType.CONSUMER}
<input name="type" type="radio" value="${MemberType.SELLER}">${MemberType.SELLER}<br/>
<input type="submit" value="join"><br>
</form>
</body>
</html>