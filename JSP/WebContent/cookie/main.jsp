<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/* Cookie[] cookies = request.getCookies();
	String name = "";
	boolean bool = false;
	
	if(cookies != null){
		for(int i = 0; i < cookies.length; i++){
			if(cookies[i].getName().equals("name")){
				name = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
				bool = true;
				break;
			}
		}
		if(bool != true){
			response.sendRedirect("loginForm.jsp");	
		}
	}
	 */
	 String name = "";
	 name = URLDecoder.decode((String)session.getAttribute("name"), "UTF-8");
	 if (name == null) {
	 	response.sendRedirect("loginForm.jsp");
	 	return;
	 }
	 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b><%= name %>님 반갑습니다.</b>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>