<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/board/write" method="post">
<h3>���ۼ�</h3>
<table border=1>
<tr>
	<th>����</th><td><input type="text" name="title"></td>
</tr>
<tr>
	<th>����</th><td><textarea cols="20" rows="10" name="content"></textarea></td>
</tr>
<tr>
	<td colspan="1"><input type="submit" name="write"></td>
</tr>	
</table>
<input type="hidden" name="writer" value="${sessionScope.id }">
</form>
</body>
</html>