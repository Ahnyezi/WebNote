<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
function edit(){
	pwd = prompt("비밀번호 확인")
	if(pwd=='${m.pwd}'){
		f.submit()
	}else{
		alert()
	}
}
</script>
</head>
<body>
<h3>${m.id }님의 info</h3>
<form action="${pageContext.request.contextPath }/member/edit" method= "post" name="f">
<table border=1>
	<tr>
		<th>id</th><td><input type="text" name="id" value ="${m.id}" readonly></td>
	</tr>
	<tr>
		<th>pwd</th><td><input type="password" name="pwd" value ="${m.pwd}"></td>
	</tr>
	<tr>
		<th>name</th><td><input type="text" name="name" value ="${m.name}" readonly></td>
	</tr>
	<tr>
		<th>email</th><td><input type="text" name="email" value ="${m.email}"></td>
	</tr>
	<tr>
		<td colspan=2><input type="button" value="edit" onclick="edit()"></td>
	</tr>
</table>
</form>
</body>
</html>