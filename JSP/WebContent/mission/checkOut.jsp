<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	List list = (List)session.getAttribute("products");
    	request.setAttribute("list", list);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="list == null">
			<b>선택한 상품이 없습니다.</b>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach var="p" items="${list}">
					<li>${p}</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
</body>
</html>