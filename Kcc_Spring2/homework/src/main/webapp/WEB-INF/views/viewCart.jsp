<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
    <h1>장바구니</h1>
    <c:choose>
        <c:when test="${empty cartItems}">
            <p>장바구니가 비어 있습니다.</p>
        </c:when>
        <c:otherwise>
            <ul>
                <c:forEach var="item" items="${cartItems}">
                    <li>${item.productName}</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</body>
</html>