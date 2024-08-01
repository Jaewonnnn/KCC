
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String m_id = "kosa";
String m_pass = "1234";

String id = request.getParameter("id");
String pass = request.getParameter("pass");

String m_name = "홍길동";
String name = URLEncoder.encode(m_name, "UTF-8");

if(id.equals(m_id) && pass.equals(m_pass)){
	/* Cookie cookie = new Cookie("name", name);
	response.addCookie(cookie); */
	
	
	session.setAttribute("name", name);
	
}else{
	response.sendRedirect("loginForm.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="main.jsp">메인</a>
</body>
</html>