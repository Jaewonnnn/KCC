<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<String> list = (List<String>) session.getAttribute("productList"); 
    	/* 리스트 가져오기 */
    	/* if(list == null){
    		list = new ArrayList<String>();
    	} */
    	request.setAttribute("list", list);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<%-- <%
		if(list == null){
	%>
	<% }else{ %>
		<ul>
			<% for(int i=0; i<list.size(); i++){%>
				<li><%= list.get(i) %></li>		
			<% } %>
		
		</ul>
	<%} %> --%>
	<c:choose>
		<c:when test="${list ==null }">
			<p>그런거 없다</p>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach var="product" items="${list }">
					<li>${product }</li> <!-- 반복될 내용 넣어주기 -->
				</c:forEach>
			
			</ul>
		</c:otherwise>
	
	</c:choose>
	
	
</body>
</html>