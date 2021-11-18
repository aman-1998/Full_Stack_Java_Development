<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Loop</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10">
${i}<br>
</c:forEach>
=======================================================<br>
<c:forEach var="i" begin="1" end="10" step="2">
${i}<br>
</c:forEach>
</body>
</html>