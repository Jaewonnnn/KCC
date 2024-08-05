<%@page import="kosa.dao.BoardDao2"%>
<%@page import="kosa.model.Board" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  /* request.setCharacterEncoding("utf-8"); */
%>
<jsp:useBean id="board" class="kosa.model.Board"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>
<!-- "*" 모든 set을 가져와준다. -->
<!-- 가져와야할 이름과 class의 변수이름이 같아야한다. -->

<%
	BoardDao2 dao = BoardDao2.getInstance();
/* 	dao.insert(board); */
	
	int re = dao.insertBoard(board);
	
	if(re==1){
		/* out.println("성공"); */
		response.sendRedirect("/board/list.jsp");
	}else if(re==-1){
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