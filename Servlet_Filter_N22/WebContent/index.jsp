<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<%
	String encodedUrl = response.encodeURL(request.getContextPath());
	if(request.getSession().getAttribute("username") != null){
		String username = request.getSession().getAttribute("username").toString();
		response.getWriter().print("Welcome, " + username + "!"+"<br>");
	}
%>
<p>Learning Login, Logout and Session Management using session attribute.</p>
Click here: <a href="<%= encodedUrl %>/SiteController?page=login">Login</a><br>
Click here: <a href="<%= encodedUrl %>/SiteController?page=about">About</a><br>
Click here: <a href="<%= encodedUrl %>/MemberAreaController?action=memberArea">Member Area</a><br>
Click here: <a href="<%= encodedUrl %>/MemberAreaController?action=memberOnly">Member Only</a>
</body>
</html>