<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function a(){
	if(f.writer.value==''){
		alert('작성자 필수')
		return
	}
	if(f.pwd.value==''){
		alert('글 비밀번호 필수')
		return
	}
	if(f.content.value==''){
		alert('글 내용 필수')
		return
	}
	
	f.submit()
}
</script>
</head>
<body>
<h3>글작성</h3>
<table border="1">
<form action="/web0722/guestbook/write" method="post" name="f">
<tr>
<td>작성자</td><td><input type="text" name="writer"></td>
</tr>
<tr>
<td>글 비밀번호</td><td><input type="password" name="pwd"></td>
</tr>
<tr>
<td>내용</td><td><textarea rows="5" cols="25" name="content"></textarea></td>
</tr>
<tr>
<td colspan="2"><input type="button" value="작성" onclick="a()"></td>
</tr>
</form>
</table>
</body>
</html>
