<%@page import="kosa.dao.MembershipDao"%>
<%@page import="kosa.model.Membership"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>    
<jsp:useBean id="membership" class="kosa.model.Membership"></jsp:useBean>
<jsp:setProperty property="*" name="membership"/>
    
    
<%
	MembershipDao dao = MembershipDao.getInstance();
	dao.insert(membership);
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