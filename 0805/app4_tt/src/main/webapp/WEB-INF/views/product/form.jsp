<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>상품등록</h3>
<form action="/product" method="post" enctype="multipart/form-data">
제품명:<input type="text" name="p.name"><br/>
가격:<input type="text" name="p.price"><br/>
수량:<input type="text" name="p.amount"><br/>
상품설명:<textarea name="p.info" rows="15" cols="20"></textarea>
이미지:<input type="file" name="f"><br/>
판매자:<input  type="text" name="p.seller" value="${sessionScope.id }" readonly><br/>
<input type="submit" value="등록">
</form>
</body>
</html>