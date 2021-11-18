<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL choose when otherwise</title>
</head>
<body>
<c:choose>
	<c:when test="${param.name == 'Aman'}">
		Aman Kumar Mishra
	</c:when>
	<c:when test="${param.name == 'Shyam'}">
		Shyam Ranjan
	</c:when>
	<c:when test="${param.name == null}">
		There is no parameter
	</c:when>
</c:choose>
</body>
</html>