<%@page import="kosa.dao.BasketDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");

    String product = request.getParameter("product");
    String username = request.getParameter("username");

    if (username != null && product != null) {
        BasketDao basketDao = BasketDao.getInstance();
        basketDao.addProduct(username, product);
    } else {
        out.println("Error: Username or product is null.");
    }

    response.sendRedirect("main.jsp?username=" + username);
%>
