<%@page import="kosa.model.Board"%>
<%@page import="kosa.dao.BoardDao2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int seq = Integer.parseInt(request.getParameter("seq")); 
	//아무것도없는 null일 경우, 오류 default의 경우의수를 만들것
	BoardDao2 dao = BoardDao2.getInstance();
	Board board = dao.detailBoard(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시글 상세보기</h3>
   	<a href="/board/list.jsp">목록으로 가기</a>
   	<table border ="1" width="800">
   	<tr>
   		<th>글번호</th>
   		<td><%= board.getSeq() %></td>
   	</tr>
   	<tr>
   		<th>제목</th>
   		<td><%= board.getTitle() %></td>
   	</tr>
   	<tr>
   		<th>작성자</th>
   		<td><%= board.getWriter() %></td>
   	</tr>
   	<tr>
   		<th>작성일</th>
   		<td><%= board.getRegdate() %></td>
   	</tr>
   	<tr>
   		<th>조회수</th>
   		<td><%= board.getHitcount() %></td>
   	</tr>
   	<tr>
   		<th>내용</th>
   		<td><%= board.getContents() %></td>
   	</tr>
   </table>
   <br>
   <a href="update_form.jsp?seq=<%= board.getSeq() %>">수정하기</a>
   	
</body>
</html>