<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Member Only</title>
</head>
<body>
<%
	String encodedUrl = response.encodeURL(request.getContextPath());
%>
<a href="<%= encodedUrl %>"><button>Home</button></a><br><br>
This page is only for members
</body>
</html>