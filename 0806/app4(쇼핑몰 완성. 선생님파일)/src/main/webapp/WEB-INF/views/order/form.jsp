<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.example.app2.model.order.OrderType"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�ֹ�</h3>
<form action="/order" method="post">
��ǰ��ȣ:<input type="text" name="pnum"><br/>
�ݾ�:<input type="text" name="total_price"><br/>
����:<input type="text" name="order_num"><br/>
�ֹ���:<input type="text" name="con_id"><br/>
order type:<input name="type" type="radio" value="${OrderType.NOW}" checked>��ð���
<input name="type" type="radio" value="${OrderType.DELAY}">��ٱ���<br/>
<input type="submit" value="���">
</form>
</body>
</html>