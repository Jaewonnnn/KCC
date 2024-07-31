<%@page import="kosa.dao.BoardDao"%>
<%@page import="kosa.model.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	request.setCharacterEncoding("UTF-8");
 %>
 <jsp:useBean id="board" class="kosa.model.Board"/>

<!-- * : foma에서 오는 모든 데이터를 set함(변수명과 form의 name이 일치해야 함) -->
<!-- name은 useBean의 id와 동일해야 함 -->
<jsp:setProperty property="*" name="board"/>

<%
	BoardDao dao = BoardDao.getInstance();
	int re = dao.insert(board);
	if (re == 1){
		response.sendRedirect("/board/list.jsp");
	}else{
		out.println("실패");
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