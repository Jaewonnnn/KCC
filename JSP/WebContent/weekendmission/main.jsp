<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kosa.dao.MemberDao" %>
<%@ page import="kosa.model.Shopping" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    String product = request.getParameter("product");
    String userId = (String) session.getAttribute("id");

    if (userId != null && product != null) {
        Shopping shopping = new Shopping();
        shopping.setProduct_id("P" + System.currentTimeMillis());
        shopping.setProduct_name(product);
        shopping.setId(userId);

        MemberDao dao = MemberDao.getInstance();
        dao.insertProductToCart(shopping);
    } else {
        response.sendRedirect("loginform.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <a href="javascript:history.back()">뒤로가기</a>
    <%= product %>
</body>
</html>
