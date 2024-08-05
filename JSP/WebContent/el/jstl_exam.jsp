<%@page import="java.util.Date"%>
<%@page import="kosa.model.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 지시자 미리선언 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="fruit" value="${param.fruit }"></c:set>
	<c:out value="${fruit }"></c:out>
	
	<c:if test="${fruit == 'apple' }">
		<c:out value="사과먹어라"></c:out>
	</c:if>
	<br><br>
	
	<c:choose>
		<c:when test="${fruit == 'banana' }">
			<c:out value="바나나알러지원숭이"></c:out>
		</c:when>
		<c:when test="${fruit == 'orange' }">
			<c:out value="아ㅋㅋ한라봉이라고"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="거봉"></c:out>
		</c:otherwise>
	</c:choose>
	
	<!-- forEach -->
	<ul>
		<c:forEach var="i" begin="1" end="9">
			<li>4*${i } = ${4*i }</li>
		</c:forEach>
	</ul>
	
	<%
		List<Person> list = new ArrayList<Person>();
	
		list.add(new Person("홍길동"));
		list.add(new Person("고길동"));
		list.add(new Person("김길동"));
		
		request.setAttribute("list", list); //이거 필수다
	
	%>
	<table border="1">
		<tr>
			<td>이름</td>
		</tr>
		<c:forEach var="p" items="${list }"> <!-- 알아서 request.getAttribute 해줌 -->
		<tr>
			<td>${p.name }</td>
		</tr>
		</c:forEach>
	</table>
	<br><br>
	
	<c:set var="now" value="<%= new Date() %>"></c:set>
	before : ${now } <br>
	after: <fmt:formatDate value="${now }" pattern="yyyy-MM-dd"/>
	<br><br>
	
	<fmt:formatNumber value="3.1423426" pattern="#.00"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="0.9" type="percent"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="50000000000000" type="currency" currencySymbol="$"></fmt:formatNumber>
</body>
</html>