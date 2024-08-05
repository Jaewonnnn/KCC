<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String m_id ="kosa";
	String m_pass = "1234";
	
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	String m_name ="고길동";
	String name = URLEncoder.encode(m_name, "utf-8");
	
	if(id.equals(m_id)&&pass.equals(m_pass)){
		Cookie cookie = new Cookie("name", name);
		response.addCookie(cookie); //쿠키는 클라이언트에 저장해야한다. -> 그렇기 때문에 response
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
	 <a href="main.jsp">메인페이지로 이동</a>
</body>
</html>