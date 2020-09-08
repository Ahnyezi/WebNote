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
<h3>나의 주문 목록(${order_type })</h3>
<table border="1">
<tr><th>주문번호</th><th>상품명</th><th>주문수량</th><th>결제금액</th></tr>
<c:forEach var="o" items="${list }">
<tr><td>${o.num }</td>
<td>${o.pnum.name }</td>
<td>${o.order_num }</td><td>${o.total_price }</td></tr>
</c:forEach>
</table>
</body>
</html>