<%@ page import="java.io.*, kosa.dao.UserDao, kosa.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");
    String password = request.getParameter("password");

    User user = new User();
    user.setId(id);
    user.setPassword(password);

    UserDao userDao = UserDao.getInstance();
    int result = userDao.signup(user);

    if(result > 0) {
        // 회원가입 성공 시 login.jsp로 이동
        response.sendRedirect("login.jsp");
    } else {
        // 회원가입 실패 시 에러 메시지 출력
        out.println("회원가입에 실패하였습니다. 다시 시도해주세요.");
    }
%>
