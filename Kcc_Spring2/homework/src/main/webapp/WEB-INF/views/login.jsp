<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�α���</h1>
	<form action="/home/login" method="post">
		<label for="id">���̵�: </label> <input type="text" id="id" name="id"
			required> <br> <label for="pass">�н�����:</label> <input
			type="password" id="pass" name="pass" required> <br>
		<button type="submit">�α���</button>
	</form>
	<a href="/home/signup">ȸ�������ϱ�</a>
</body>
</html>