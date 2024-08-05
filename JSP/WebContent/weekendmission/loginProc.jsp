<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String m_id ="kosa";
    String m_pass = "1234";
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    String name ="고길동";

    if(id.equals(m_id) && pass.equals(m_pass)){
        session.setAttribute("id", m_id);
        session.setAttribute("name", name);
        response.sendRedirect("main.jsp");
    } else {
        response.sendRedirect("loginform.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Processing</title>
</head>
<body>
    <a href="main.jsp">메인페이지로 가기</a>
</body>
</html>
