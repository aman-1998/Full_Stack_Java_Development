<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/mvc_controller?page=natural">First 10 Natural no.</a><br>
	<a href="<%= request.getContextPath() %>/mvc_controller?page=countries">Top 5 most powerful countries</a><br>
</body>
</html>