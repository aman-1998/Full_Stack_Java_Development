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

<c:import url="/StudentsData.xml" var="StudentsXMLFile"></c:import>

<x:parse xml="${StudentsXMLFile}" var="parsableXMLFile"></x:parse>

Name: <x:out select="$parsableXMLFile/students/student[1]/name"/><br>
Class: <x:out select="$parsableXMLFile/students/student[1]/class"/><br>
Roll: <x:out select="$parsableXMLFile/students/student[1]/roll"/><br><br>

Name: <x:out select="$parsableXMLFile/students/student[2]/name"/><br>
Class: <x:out select="$parsableXMLFile/students/student[2]/class"/><br>
Roll: <x:out select="$parsableXMLFile/students/student[2]/roll"/><br><br>

</body>
</html>