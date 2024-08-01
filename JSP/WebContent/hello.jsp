<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 페이지</h1>
	<%
/* 	request.getParameter(name)
	response.sendRedirect(location) */
	 String name = "홍길동";
	%>
	이름 : <%=name %>
</body>
</html>
