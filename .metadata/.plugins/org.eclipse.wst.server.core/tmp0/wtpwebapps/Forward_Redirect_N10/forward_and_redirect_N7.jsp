<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	This content is from forward_and_redirect_N7.jsp
	<%
		response.sendRedirect("Forward_And_Redirect_N5");
	%>
</body>
</html>