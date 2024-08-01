<%@page import="kosa.model.Blog"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kosa.model.Search"%>
<%@page import="kosa.dao.BoardDao2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kosa.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="kosa.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
request.setCharacterEncoding("UTF-8");

Map<String, Object> map = new HashMap<>();
map.put("area", request.getParameterValues("area"));
map.put("searchKey", "%" + request.getParameter("searchKey") + "%");

BoardDao2 dao = BoardDao2.getInstance();
List<Board> list = dao.listBoard(map);

Blog blog = dao.selectBlog(100);
System.out.println(blog);
request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<h3>글목록</h3>
	<a href="insert_form.jsp">글쓰기</a>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${list}">
		<tr>
			<td><c:out value="${board.seq}"/></td>
			<td><a href="detail.jsp?seq=${board.seq}"><c:out value="${board.title}"/></a></td>
			<td><c:out value="${board.writer}"/></td>
			<td>
				<fmt:parseDate var="dt" value="${board.regdate}" pattern="yyyy-MM-dd"/>
				<fmt:formatDate value="${dt}" pattern="yyyy/MM/dd"/>
			</td>
			<td><c:out value="${board.hitcount}"/></td>
		</tr>
		</c:forEach>
	</table>
	<br><br>

	<form action="list.jsp" method="GET">
		<input type="checkbox" name="area" value="title">제목 
		<input type="checkbox" name="area" value="writer">작성자 
		<input type="text" name="searchKey" size="10"> 
		<input type="submit" value="검색">
	</form>
</body>
</html>
