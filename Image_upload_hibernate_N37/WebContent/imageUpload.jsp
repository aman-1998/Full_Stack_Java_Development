<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Upload</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}">Home</a></h1>
<form action="${pageContext.request.contextPath}/image-upload?operation=uploadImage" method="post" enctype="multipart/form-data">
Select files: <input type="file" name="files" multiple>
<input type="submit" value="upload">
</form>
</body>
</html>