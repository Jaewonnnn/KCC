<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 결과</title>
</head>
<body>
    <h1>회원가입 결과</h1>
    <p>이름: <%= request.getAttribute("userName") %></p>
    <p>아이디: <%= request.getAttribute("userID") %></p>
    <p>이메일: <%= request.getAttribute("userEmail") %></p>
    <p>연락처: <%= request.getAttribute("userPhoneNumber") %></p>
    <p>메일 수신 여부: <%= request.getAttribute("subscribe") != null ? "받음" : "받지 않음" %></p>
</body>
</html>
