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
		alert("�ۼ��ڴ� �ʼ��Է»����Դϴ�.")
		f.writer.focus();
		return;
	}
	if(f.pwd.value.length==0){
		alert("��й�ȣ�� �ʼ��Է»����Դϴ�.")
		f.pwd.focus();
		return;
	}
	if(f.content.value.length==0){
		alert("�ۼ����� �ʼ��Է»����Դϴ�.")
		f.content.focus();
		return;
	}
	f.submit();
}
</script>
</head>
<body>
<table border=1>
<h3>�� �ۼ�</h3>
<form action="/web0722/guestbook/Controller?cmd=write" method="post" name="f">
<tr>
	<td>�ۼ���</td><td><input type="text" name="writer"></td>
</tr>
<tr>
	<td>�� ��й�ȣ</td><td><input type="text" name="pwd"></td>
</tr>
<tr>
	<td>�� ����</td><td><textarea rows=5 cols=20 name="content"></textarea></td>
</tr>
<tr>
	<td colspan=2><input type="button" value="�Ϸ�" onclick="check()"></td>
</tr>
</form>
</table>
</body>
</html>


