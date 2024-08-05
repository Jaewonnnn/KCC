<%@page import="kosa.Blog"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" import="net.sf.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%!List<Blog> list;%>


<%
   String title = request.getParameter("title");
   String writer = request.getParameter("writer");
   String contents = request.getParameter("contents");

   if (list == null) {
      list = new ArrayList<Blog>();
      if (title != null) {
         list.add(new Blog(title, writer, contents));
      }
   } else if (title != null) {
      list.add(new Blog(title, writer, contents));
   }

   if (list != null && !list.isEmpty()) {
	    String json = JSONArray.fromObject(list).toString();
	    response.setContentType("application/json; charset=UTF-8"); // JSON 형식으로 응답
	    out.print(json);
	}

%>