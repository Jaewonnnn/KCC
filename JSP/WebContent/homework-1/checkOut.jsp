<%@page import="kosa.dao.BasketDao"%>
<%@page import="kosa.model.Basket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%
    request.setCharacterEncoding("UTF-8");

    String username = request.getParameter("username");
    if (username == null) {
        out.println("로그인이 필요합니다.");
        return;
    }

    BasketDao basketDao = BasketDao.getInstance();
    List<Basket> productList = basketDao.getProductsByUserId(username);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div align="center">
        <h2>장바구니</h2>
        <hr>
        <ul>
            <% for (Basket basket : productList) { %>
                <li><%= basket.getProduct() %></li>
            <% } %>
        </ul>
        <a href="main.jsp?username=<%= username %>">뒤로</a>
    </div>
</body>
</html>
