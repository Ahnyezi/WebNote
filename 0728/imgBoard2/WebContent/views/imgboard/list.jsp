<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>얼굴 책</h3>
<form action="${pageContext.request.contextPath }/ImgBoardController?cmd=write" method="post" 
enctype="multipart/form-data">
<table border="1">
<tr><th>title</th><td><input type="text" name="title"></td></tr>
<tr><th>writer</th><td><input type="text" name="writer"></td></tr>
<tr><th>img</th><td><input type="file" name="file"></td></tr>
<tr><td colspan="2"><input type="submit" value="upload"></td></tr>
</table>
</form>
<c:forEach var="ib" items="${list }">
<table border="1">
<tr><th>num</th><td>${ib.num }</td></tr>
<tr><th>title</th><td><input type="text" name="title" value="${ib.title }" readonly></td></tr>
<tr><th>writer</th><td><input type="text" name="writer" value="${ib.writer }" readonly></td></tr>
<tr><th>img</th><td><img src="${ib.img }" width="400" height="300"></td></tr>
</table>
</c:forEach>
</body>
</html>