<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>글작성</h3>
<form action="${pageContext.request.contextPath }/BoardController?cmd=write" method="post">
<table border="1">
<tr><th>제목</th><td><input type="text" name="title"></td></tr>
<tr><th>내용</th><td><textarea cols="20" rows="10" name="content"></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="작성"></td></tr>
</table>
<input type="hidden" name="writer" value="${sessionScope.id }">
</form>
</body>
</html>