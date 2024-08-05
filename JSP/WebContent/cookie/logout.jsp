<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Cookie[] cookies = request.getCookies();
	boolean bool = false;

	if(cookies != null){
		for(int i =0; i<cookies.length; i++){
			if(cookies[i].getName().equals("name")){
				/* encode로 가져왔으니 decode */
				cookies[i].setMaxAge(0); //쿠키를 만료 시키기
				response.addCookie(cookies[i]);
				bool = true;
				break;
			}
		}
		
		if(bool!=true){
			response.sendRedirect("loginFrom.jsp");
		}
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>