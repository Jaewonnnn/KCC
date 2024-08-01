<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<H2>회원가입</H2>
	<form name="form" method="POST" action="signupAction.jsp">
		id : <input type="text" name="id"/><br>
		pw : <input type="password" name="password"/><br>
		<input type="submit" value="회원가입"/>
	</form>
</body>
</html>
