<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/home/login" method="post">
		<label for="userId">아이디: </label> 
		<input type="text" id="userId" name="userId" required> <br> 
		<label for="password">패스워드:</label> 
		<input type="password" id="password" name="password" required> <br>
		<button type="submit">로그인</button>
	</form>
	<a href="/home/signup">회원가입하기</a>
</body>
</html>
