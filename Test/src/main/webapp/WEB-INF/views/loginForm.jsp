<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<center>
<h3>Login 하세요</h3>
<hr/>
<form action = "login.do" method = "post">
<table border = 1 cellpadding = 0 cellspacing = 0>
	<tr>
		<td>아이디</td>
		<td><input type = "text" name = "id" /></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type = "password" name = "password"/></td>
	</tr>
	<tr>
		<td align = center colspan = 2><input type = "submit" value = "로그인" /> </td>
	</tr>
	
</table>
</form>
<hr/>
</center>
</body>
</html>