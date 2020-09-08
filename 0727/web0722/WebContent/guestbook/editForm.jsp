<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
function edit(num,pwd){
	pwd2 = prompt("글 비밀번호를 입력하세요.")
	if(pwd==pwd2){
		ta = document.getElementById("content");
		str = ta.value;
		alert("수정내용\n"+str);
		location.href = "/web0722/guestbook/Controller?cmd=edit&content="+str+"&num="+num;
	}
	else{
		alert("비밀번호가 틀립니다.")
		return
	}
}
function del(num,pwd){
	pwd2 = prompt("글 비밀번호를 입력하세요.")
	if(pwd==pwd2){
		location.href = "/web0722/guestbook/Controller?cmd=del&num="+num;
	}
	else{
		alert("비밀번호가 틀립니다.")
		return
	}
}
</script>
</head>
<body>
<h3>${a.num}번 글</h3>
<table border = 1>
	<tr>
		<th>작성자</th><td><input type="text" name="writer" value ="${a.writer}" readonly></td>
	</tr>
	<tr>
		<th>작성일</th><td><input type="text" name="w_date" value ="${a.w_date}" readonly></td>
	</tr>
	<tr>
		<th>글 내용</th><td><textarea type="text" id="content">${a.content}</textarea></td>
	</tr>
	<tr>
		<td colspan=2><input type="button" value ="수정" onclick="edit(${a.num},'${a.pwd}')">
			<input type="button" value="삭제" onclick="del(${a.num},'${a.pwd}')">
		</td>
	</tr>
</table>
</body>
</html>