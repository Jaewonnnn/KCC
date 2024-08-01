<%@page import="kosa.dao.UserDao"%>
<%@page import="kosa.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");
    String password = request.getParameter("password");

    User user = new User();
    user.setId(id);
    user.setPassword(password);

    UserDao userDao = UserDao.getInstance();
    User result = userDao.login(user);

    if(result != null) {
        String username = result.getId();
        response.sendRedirect("main.jsp?username=" + username);
    } else {
        out.println("로그인 실패");
    }
%>
