<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.example.app2.model.order.OrderType"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
	$("#total_price").val($("#price").val())
	
  $("#order_num").click(function(){
	  var num = $("#order_num option:selected").val()	  
	  var price = $("#price").val()
	  var result = eval(num*price)
	  $("#total_price").val(result)
  });
});
</script>
</head>
<body>
<h3>상품명: ${p.name }</h3>
<form action="/order" method="post">
<input type="hidden" name="pnum" value="${p.num }">
<table border="1">
<tr>
<th>price</th><td><input type="text" id="price" value="${p.price }"></td>
</tr>
<tr>
<th>order num</th>
<td><select name="order_num" id="order_num">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select></td>
</tr>
<tr>
<th>total_price</th><td><input type="text" name="total_price" id="total_price"></td>
</tr>
<tr>
<th>img</th><td><img src="http://localhost:7878${p.img }" style="width:150px;height:150px"></td>
</tr>
<tr>
<th>info</th><td><textarea rows="10" cols="35" readonly>${p.info }</textarea></td>
</tr>
<tr>
<th>seller</th><td><input type="text" name="seller" value="${p.seller.id }"  readonly></td>
</tr>
<tr>
<th>결제</th><td><input type="radio" name="type" value="${OrderType.NOW }" checked>즉시결제
<input type="radio" name="type" value="${OrderType.DELAY }">장바구니
<input type="submit" value="주문"></td>
</tr>
</table>
<input type="hidden" name="con_id" value="${sessionScope.id}">
</form>
</body>
</html>