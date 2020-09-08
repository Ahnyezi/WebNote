<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#del").click(function(){
	  location.href="/product/${p.num }/del";
  });
});
</script>
</head>
<body>
<h3>product details</h3>
<form action="/product/edit" method="post">
<table border="1">
<tr>
<th>num</th><td><input type="text" name="num" value="${p.num }" readonly></td>
</tr>
<tr>
<th>name</th><td><input type="text" name="name" value="${p.name }"></td>
</tr>
<tr>
<th>price</th><td><input type="text" name="price" value="${p.price }"></td>
</tr>
<tr>
<th>amount</th><td><input type="text" name="amount" value="${p.amount }"></td>
</tr>
<tr>
<th>img</th><td><img src="http://localhost:7878${p.img }" style="width:150px;height:150px"></td>
</tr>
<tr>
<th>info</th><td><textarea rows="10" cols="35" name="info">${p.info }</textarea></td>
</tr>
<tr>
<th>seller</th><td><input type="text" name="seller" value="${p.seller.id }"  readonly></td>
</tr>
<tr>
<th>edit/del</th><td><input type="submit" value="수정"><input type="button" value="삭제" id="del"></td>
</tr>
</table>
<input type="hidden" name="img" value="${p.img }">
</form>
</body>
</html>