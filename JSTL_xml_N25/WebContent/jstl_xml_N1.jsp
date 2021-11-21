<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL parse and out tag</title>
</head>
<body>

<c:import url="/StudentsData.xml" var="StudentXMLFile"></c:import>

<x:parse xml="${StudentXMLFile}" var="parsableXMLFile"></x:parse>

<b>Name:</b> <x:out select="$parsableXMLFile/students/student/name"/><br>
<b>Roll:</b> <x:out select="$parsableXMLFile/students/student/roll"/><br>
<b>Class:</b> <x:out select="$parsableXMLFile/students/student/class"/><br>

</body>
</html>