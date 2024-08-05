<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String m_id ="kcc";
	String m_pass = "1234";
	
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	String name ="고길동";
/* 	String name = URLEncoder.encode(m_name, "utf-8"); */
	
	if(id.equals(m_id)&&pass.equals(m_pass)){
		//session 관련내용 -> 먼저 setAttribute로 설정하기 -> 그다음에 response ㄱㄱ
		session.setAttribute("id", m_id);
		session.setAttribute("name", name);
		response.sendRedirect("main.jsp");
	}else{
		response.sendRedirect("loginform.jsp");
	}
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <a href="main.jsp">메인페이지로 이동</a>
</body>
</html>