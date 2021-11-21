<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL forEach and if tag</title>
</head>
<body>

<c:import url="/StudentsData.xml" var="studentXMLFile"></c:import>

<x:parse xml="${studentXMLFile}" var="parsableXMLFile"></x:parse>

<x:forEach select="$parsableXMLFile/students/student">
	<x:if select="gender = 'Male'">
		Name: <x:out select="name"/><br>
		Class: <x:out select="class"/><br>
		Roll: <x:out select="roll"/><br><br>
	</x:if>
</x:forEach>

</body>
</html>