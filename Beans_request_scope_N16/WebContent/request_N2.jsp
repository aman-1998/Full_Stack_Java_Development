<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="student" class="bean_request.Student" scope="request"></jsp:useBean>
	Name: <jsp:getProperty property="name" name="student"/><br>
	Roll No: <jsp:getProperty property="rollNo" name="student"/>
</body>
</html>