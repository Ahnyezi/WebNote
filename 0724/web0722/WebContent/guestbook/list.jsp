<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="java.util.ArrayList,guestbook.Article" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>방명록</h3>
<a href="/web0722/guestbook/Controller?cmd=writeForm">글작성</a><br/>
<table border=1>
<%
	ArrayList<Article> list = (ArrayList<Article>)request.getAttribute("list");
	for(Article a:list){
%>
	<tr>
		<th>글번호</th><td><a href="/web0722/guestbook/Controller?cmd=editForm&num=<%=a.getNum()%>"><%=a.getNum()%></a></td>
	</tr>
	<tr>
		<th>작성자</th><td><%=a.getWriter()%></td>
	</tr>
	<tr>
		<th>작성일</th><td><%=a.getW_date()%></td>
	</tr>
	<tr>
		<th>글내용</th><td><%=a.getContent()%></td>
	</tr>
<% } %>
</table>
</body>
</html>