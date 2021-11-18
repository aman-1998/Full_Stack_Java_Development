<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="beans.User" scope="application"></jsp:useBean>
	<jsp:setProperty property="firstName" name="user" value="Ajit"/>
	<jsp:setProperty property="lastName" name="user" value="Yadav"/>
	Property set...
</body>
</html>