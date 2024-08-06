<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   		<td>${board.seq}</td>
   	</tr>
   	<tr>
   		<th>제목</th>
   		<td>${board.title}</td>
   	</tr>
   	<tr>
   		<th>작성자</th>
   		<td>${board.writer}</td>
   	</tr>
   	<tr>
   		<th>작성일</th>
   		<td>${board.regdate}</td>
   	</tr>
   	<tr>
   		<th>조회수</th>
   		<td>${board.hitcount}</td>
   	</tr>
   	<tr>
   		<th>내용</th>
   		<td>${board.contents}</td>
   	</tr>
   </table>
   <br>
   <a href="update_form.jsp?seq=">수정하기</a>
   	
</body>
</html>