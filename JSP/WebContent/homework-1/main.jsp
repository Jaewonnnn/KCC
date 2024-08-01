<%@page import="kosa.dao.BasketDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%
    request.setCharacterEncoding("utf-8");
    String username = request.getParameter("username");
    if (username == null) {
        out.println("로그인이 필요합니다.");
        return;
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<title>ch06 : selProduct.jsp</title>
</HEAD>
<body>
<div align="center">
    <H2>상품선택</H2>
    <HR>
    <%= username %> 님 환영합니다
    <HR>
    <form name="form1" method="POST" action="add.jsp">
        <input type="hidden" name="username" value="<%= username %>"/>
        <SELECT name="product">
            <option>사과</option>
            <option>귤</option>
            <option>파인애플</option>
            <option>자몽</option>
            <option>레몬</option>
        </SELECT>
        <input type="submit" value="추가"/>
    </form>
    <a href="checkOut.jsp?username=<%= username %>">계산</a>
</div>
</body>
</HTML>
