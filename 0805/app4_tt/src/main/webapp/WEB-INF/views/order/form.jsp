<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.example.app2.model.order.OrderType"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>주문</h3>
<form action="/order" method="post">
제품번호:<input type="text" name="pnum"><br/>
금액:<input type="text" name="total_price"><br/>
수량:<input type="text" name="order_num"><br/>
주문자:<input type="text" name="con_id"><br/>
order type:<input name="type" type="radio" value="${OrderType.NOW}" checked>즉시결제
<input name="type" type="radio" value="${OrderType.DELAY}">장바구니<br/>
<input type="submit" value="등록">
</form>
</body>
</html>