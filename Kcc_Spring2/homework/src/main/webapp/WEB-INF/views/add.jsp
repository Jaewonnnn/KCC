<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 선택</title>
</head>
<body>
<div align="center">
    <h2>상품 선택</h2>	
    <hr>
    ${sessionScope.username } 님 환영합니다!!!!
    <hr>
    <form name="form1" method="POST" action="/home/addToCart">
        <select name="product">
            <option value="사과">사과</option>
            <option value="귤">귤</option>
            <option value="파인애플">파인애플</option>
            <option value="자몽">자몽</option>
            <option value="레몬">레몬</option>
        </select>
        <input type="submit" value="추가"/>
    </form>
    <a href="/home/viewCart">장바구니 보기</a>
</div>
</body>
</html>
