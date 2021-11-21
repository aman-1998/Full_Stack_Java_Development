<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL choose when otherwise tag</title>
</head>
<body>

<c:import url="/StudentsData.xml" var="studentXMLFile"></c:import>

<x:parse xml="${studentXMLFile}" var="parsableXMLFile"></x:parse>

<table border="1">
	<tr>
		<th bgcolor="#ffff80">Name</th>
		<th bgcolor="#ffff80">Class</th>
		<th bgcolor="#ffff80">Roll</th>
	</tr>
	
	<x:forEach select="$parsableXMLFile/students/student">
	<tr>
		<x:choose>
			<x:when select="gender = 'Male'">
				<td bgcolor="#b3ccff"><x:out select="name"></x:out></td>
				<td bgcolor="#b3ccff"><x:out select="class"></x:out></td>
				<td bgcolor="#b3ccff"><x:out select="roll"></x:out></td>
			</x:when>
			<x:otherwise>
				<td bgcolor="#ffccff"><x:out select="name"></x:out></td>
				<td bgcolor="#ffccff"><x:out select="class"></x:out></td>
				<td bgcolor="#ffccff"><x:out select="roll"></x:out></td>
			</x:otherwise>
		</x:choose>
	</tr>
	</x:forEach>	
</table>


</body>
</html>