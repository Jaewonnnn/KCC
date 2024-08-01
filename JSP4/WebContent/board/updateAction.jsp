<%@page import="kosa.model.Board"%>
<%@page import="kosa.dao.BoardDao2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

Board board = new Board();
board.setSeq(Integer.parseInt(request.getParameter("seq")));
board.setWriter(request.getParameter("writer"));
board.setTitle(request.getParameter("title"));
board.setContents(request.getParameter("contents"));

BoardDao2 dao = BoardDao2.getInstance();
int re = dao.updateBoard(board);
if (re == 1) {
    response.sendRedirect("/JSP4/board/list.jsp");
} else {
    out.println("실패");
}
%>
