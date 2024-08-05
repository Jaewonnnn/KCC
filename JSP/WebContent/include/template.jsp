<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		String body = request.getParameter("body");
	
		if(body==null){
			body = "/include/main.jsp";
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<jsp:include page="/include/module/header.jsp"></jsp:include>
	<hr>
	
	<!-- logo -->
	<jsp:include page="/include/module/logo.jsp"></jsp:include>
	<hr>
	
	<!-- menu -->
	<jsp:include page="/include/menu.jsp"></jsp:include>
	<hr>
	
	<!-- body -->
	<jsp:include page="<%= body %>"></jsp:include>
	

	<!-- footer -->
	<jsp:include page="/include/module/footer.jsp"></jsp:include>
</body>
</html>