<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	It is from forward_and_redirect_N3.jsp
	<%
		request.getRequestDispatcher("forward_and_redirect_N4.jsp").forward(request, response);
	%>
</body>
</html>