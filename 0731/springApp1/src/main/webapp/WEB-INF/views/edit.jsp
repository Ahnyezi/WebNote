<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>edit form</h3>
<h3>${m.id }님의 info</h3>
<form action="${pageContext.request.contextPath }/member/edit" method= "post">
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
		<th>type</th><td><input type="text" name="type" value ="${m.type}" readonly></td>
	</tr>
	<tr>
		<td colspan=2><input type="submit" value="edit"></td>
	</tr>
</table>
</form>
</body>
</html>