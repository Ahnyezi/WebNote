<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
function a(){
	if(f.pwd.value=="" || f.pwd.value==null){
		f.pwd.value='${m.pwd}'
	}
	f.submit();
}
</script>
</head>
<body>
<h3>${sessionScope.id }님의 info</h3>
<form action="${pageContext.request.contextPath }/MemController?cmd=edit" method= "post" name=f>
<table border=1>
	<tr>
		<th>id</th><td><input type="text" name="id" value ="${m.id}" readonly></td>
	</tr>
	<tr>
		<th>pwd</th><td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<th>name</th><td><input type="text" name="name" value ="${m.name}" readonly></td>
	</tr>
	<tr>
		<th>email</th><td><input type="text" name="email" value ="${m.email}"></td>
	</tr>
	<tr>
		<td colspan=2><input type="button" value="수정" onclick= "a()"></td>
	</tr>
</table>
</form>
</body>
</html>