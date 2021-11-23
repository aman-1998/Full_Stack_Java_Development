<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formatting Number</title>
</head>
<body>
<c:set var="number" value="72881.62862"></c:set>
Number: <c:out value="${number}"></c:out><br>
Number: <fmt:formatNumber type="number" maxIntegerDigits="3" value="${number}"/><br>
Number: <fmt:formatNumber type="number" maxFractionDigits="2" value="${number}"/><br>
Number: <fmt:formatNumber type="currency" value="${number}"/><br>

<fmt:setLocale value="hi_IN"/>
Number: <fmt:formatNumber type="currency" value="${number}"/><br>

<fmt:setLocale value="el_GR"/>
Number: <fmt:formatNumber type="currency" value="${number}"/>
</body>
</html>