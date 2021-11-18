<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learning JSTL core tage</title>
</head>
<body>
<%-- param is an implicit object. Go to: https://www.javatpoint.com/EL-expression-in-jsp 
 or Go to: https://studyeasy.org/general/implicit-objects/ --%>
<c:out value="${param.msg}"></c:out><br>
${param.msg} 
</body>
</html>