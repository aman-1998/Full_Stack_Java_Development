<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%! public String name = "Aman Mishra"; %> <%-- Access modifier is allowed --%>
	<%= name %>
	<br>
	<%! public String nation() {
		return "India is my country";
	} %> <%-- Functions can also be declared --%>
	<br>
	<%= nation() %> <%-- function calling --%>
</body>
</html>