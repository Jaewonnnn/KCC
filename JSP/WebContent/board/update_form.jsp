<%@page import="kosa.model.Board"%>
<%@page import="kosa.dao.BoardDao2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    int seq = Integer.parseInt(request.getParameter("seq"));
    BoardDao2 dao = BoardDao2.getInstance();
    Board board = dao.detailBoard(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
    <h3>게시글 수정</h3>
    <form action="updateAction.jsp" method="post">
        <input type="hidden" name="seq" value="<%= board.getSeq() %>">
        <table border="1" width="800">
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value="<%= board.getTitle() %>" required></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="writer" value="<%= board.getWriter() %>" required></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="contents" rows="10" cols="80" required><%= board.getContents() %></textarea></td>
            </tr>
        </table>
        <input type="submit" value="수정하기">
    </form>
    <br>
    <a href="/board/list.jsp">목록으로 가기</a>
</body>
</html>
