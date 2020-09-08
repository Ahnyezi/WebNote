<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
function a(){
	location.href="${pageContext.request.contextPath}/board/del?num=${b.num}"
}
</script>
</head>
<body>
<c:if test="${sessionScope.id!=b.writer }">
<c:set var="read">readonly</c:set>
</c:if>
<h3>글 상세페이지</h3>
<a href ="${pageContext.request.contextPath }/board/list">글목록</a><br/>
<form action="${pageContext.request.contextPath }/board/edit?num=${b.num }" method="post">
<table border="1">
<tr>
	<th>글번호</th><td><input type="text" value="${b.num }" name="num" readonly></td>
</tr>
<tr>
	<th>제목</th><td><input type="text" value="${b.title }" name="title"${read }></td>
</tr>
<tr>
	<th>작성자</th><td><input type="text" value="${b.writer }" name="writer" readonly></td>
</tr>
<tr>
	<th>작성일</th><td><input type="text" value="${b.w_date }" name="w_date" readonly></td>
</tr>
<tr>
	<th>내용</th><td><textarea name="content" cols="20" rows="10" ${read}>${b.content }</textarea></td>
</tr>
<c:if test="${sessionScope.id==b.writer }">
	<tr>
		<td colspan="2"><input type="submit" value="edit"><input type="button" value="del" onclick="a()"></td>
	</tr>
</c:if>
</table>
</form>
</body>
</html>