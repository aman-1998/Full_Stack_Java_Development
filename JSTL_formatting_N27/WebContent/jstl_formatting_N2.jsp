<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formatting Date</title>
</head>
<body>
<%@ page import="java.util.Date" %>
<%
	Date date = new Date();
%>
<c:set var="dateTime" value="<%=date%>"/>
Date, Time and Time-zone: <c:out value="${dateTime}"/><br>
Date: <fmt:formatDate type="date" value="${dateTime}"/><br>
Time: <fmt:formatDate type="time" value="${dateTime}"/><br>

Date, Time and Time-Zone: <fmt:formatDate type="both" timeZone="GMT-1" value="${dateTime}"/><br>

<fmt:setLocale value="hi_IN"/>
Date, Time and Time-Zone: <fmt:formatDate type="both" timeZone="GMT-1" value="${dateTime}"/>
</body>
</html>