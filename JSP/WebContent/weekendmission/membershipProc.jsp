<%@page import="kosa.dao.MemberDao"%>
<%@page import="kosa.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    String userName = request.getParameter("userName");
    String userID = request.getParameter("userID");
    String userPass = request.getParameter("userPass");
    String userPassCheck = request.getParameter("userPassCheck");
    String emailPrefix = request.getParameter("emailPrefix");
    String emailDomain = request.getParameter("emailDomain");
    String emailCustom = request.getParameter("emailCustom");
    String contact = request.getParameter("contact");
    String subscribe = request.getParameter("subscribe");

    String email = emailDomain.equals("custom") ? emailCustom : emailPrefix + "@" + emailDomain;

    Member member = new Member(userID, userPass, userName, email);
    MemberDao dao = MemberDao.getInstance();
    dao.insertMember(member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Membership Result</title>
</head>
<body>
	<h1>회원가입결과</h1>
   <p>이름: ${userName}</p>
   <p>ID: ${userID}</p>
   <p>비밀번호: ${userPass}</p>
   <p>이메일: ${email}</p>
   <p>Contact: ${contact}</p>
   <p>이메일 송신여부: ${subscribe}</p>
   <p>회원가입ㅊㅊ</p>
</body>
</html>
