<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
function check(){
	if(f.writer.value.length==0){
		alert("작성자는 필수입력사항입니다.")
		f.writer.focus();
		return;
	}
	if(f.pwd.value.length==0){
		alert("비밀번호는 필수입력사항입니다.")
		f.pwd.focus();
		return;
	}
	if(f.content.value.length==0){
		alert("작성글은 필수입력사항입니다.")
		f.content.focus();
		return;
	}
	f.submit();
}
</script>
</head>
<body>
<table border=1>
<h3>글 작성</h3>
<form action="/web0722/guestbook/Controller?cmd=write" method="post" name="f">
<tr>
	<td>작성자</td><td><input type="text" name="writer"></td>
</tr>
<tr>
	<td>글 비밀번호</td><td><input type="text" name="pwd"></td>
</tr>
<tr>
	<td>글 내용</td><td><textarea rows=5 cols=20 name="content"></textarea></td>
</tr>
<tr>
	<td colspan=2><input type="button" value="완료" onclick="check()"></td>
</tr>
</form>
</table>
</body>
</html>


