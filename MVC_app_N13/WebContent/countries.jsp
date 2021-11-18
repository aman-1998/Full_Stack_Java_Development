<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="display.Display_Country" %>
	<%
		response.getWriter().print("Top 5 most powerful countries:-" + "<br>");
		Display_Country disp = new Display_Country();
		disp.display(response);
	%>
</body>
</html>