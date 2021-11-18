<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL choose when other</title>
</head>
<body>
<c:choose>
	<c:when test="${param.name == 'Aman'}">
		Aman Kumar Mishra
	</c:when>
	<c:when test="${param.name == 'Diksha'}">
		Diksha Shaw
	</c:when>
	<c:otherwise>
		Ab kya bole batao ?
	</c:otherwise>
</c:choose>
</body>
</html>