<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learning to include file</title>
</head>
<body>
	<%-- It is used to include static content --%>
	<%@ include file="files/file1.txt" %>
	<br>
	<%-- It is used to add dynamic content --%>
	<jsp:include page="files/file2.txt"></jsp:include>
</body>
</html>