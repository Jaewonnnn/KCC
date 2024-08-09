<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/home/login" method="post">
		<label for="id">아이디: </label> <input type="text" id="id" name="id"
			required> <br> <label for="pass">패스워드:</label> <input
			type="password" id="pass" name="pass" required> <br>
		<button type="submit">로그인</button>
	</form>
	<a href="/home/signup">회원가입하기</a>
</body>
</html>