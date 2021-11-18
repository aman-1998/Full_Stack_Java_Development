<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servlet Context learning</title>
</head>
<body>
<%
	String URL = "<a href='https://www.flipkart.com'>Flipkart</a>";
	ServletContext context = getServletContext();
	context.setAttribute("url", URL);
%>
Click here: ${url}<br>
Click here: <c:out value="${url}"></c:out>
</body>
</html>