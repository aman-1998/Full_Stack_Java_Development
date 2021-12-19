<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
Click here to view images: <a href="${pageContext.request.contextPath}/galleryAppController?page=listingimages">view</a><br>
Click here to upload images: <a href="${pageContext.request.contextPath}/galleryAppController?page=imageUpload">Upload</a>
</body>
</html>