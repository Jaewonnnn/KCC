<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="kosa.dao.MemberDao" %>
<%@ page import="kosa.model.Shopping" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String userId = (String) session.getAttribute("id");
    List<Shopping> list = new ArrayList<>();

    if (userId != null) {
        MemberDao dao = MemberDao.getInstance();
        list = dao.selectCartByUserId(userId);
    } else {
        response.sendRedirect("loginform.jsp");
    }

    request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:choose>
        <c:when test="${empty list}">
            <p>장바구니가 비어 있습니다.</p>
        </c:when>
        <c:otherwise>
            <ul>
                <c:forEach var="product" items="${list}">
                    <li>${product.product_name}</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</body>
</html>
