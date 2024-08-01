<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kosa.model.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="fruit" value="${param.fruit}"></c:set>
	<c:out value="${fruit}" />

	<c:if test="${fruit == 'apple' }">
		<c:out value="사과입니다." />
	</c:if>

	<c:choose>
		<c:when test="${fruit=='banana'}">
			<c:out value="바나나"></c:out>
		</c:when>
		<c:when test="${fruit=='orange'}">
			<c:out value="오렌지"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="수박"></c:out>
		</c:otherwise>
	</c:choose>

	<!-- forEach -->
	<ul>
		<c:forEach var="i" begin="1" end="9">
			<li>4 * ${i} = ${4*i}</li>
		</c:forEach>
	</ul>

	<%
	List<Person> list = new ArrayList<Person>();
	list.add(new Person("홍길동"));
	list.add(new Person("박길동"));
	list.add(new Person("조길동"));

	request.setAttribute("list", list);// 이걸 꼭 해줘야 함.
	%>

	<table>
		<tr>
			<td>이름</td>
		</tr>
		<c:forEach var="p" items="${list}">
			<tr>
				<td>${p.name}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	
	<c:set var="now" value="<%= new Date() %>"></c:set>
	before: ${now}<br>
	after: <fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>
	<br><br>
	
	<fmt:formatNumber value="3.141592" pattern="#.00"/><br>
	<fmt:formatNumber value="0.9" type="percent"/><br>
	<fmt:formatNumber value="50000000000000000" type='currency' currencySymbol="$"/>
	
</body>
</html>