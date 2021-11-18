<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL forTokens</title>
</head>
<body>
<c:forTokens items="www.amanmishra.com" delims="." var="token">
${token}<br>
</c:forTokens>
==========================================================================<br>
<%
	String url = "www.studyeasy.com";
%>
<c:forTokens items="<%=url%>" delims="." var="token">
${token}<br>
</c:forTokens>
</body>
</html>