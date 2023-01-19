<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List,personal.learning.entity.FilesInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/modalStyle.css">
<title>Gallery</title>
</head>
<body>

<!-- The Modal -->
<div id="myModal" class="modal">
  <span class="close">&times;</span>
  <img class="modal-content" id="viewImage">
  <div id="caption"></div>
</div>

<h1>Listing Images | <a href="${pageContext.request.contextPath}">Home</a></h1>
<table id="imageTable" border=1 >
	<tr bgcolor="#ffdb96">
		<th>Preview</th>
	   	<th>Available Information</th>
	  	<th>Update Information</th>
	   	<th>Action</th>
	</tr>
	<%
		List<FilesInfo> filesList = (List<FilesInfo>) request.getAttribute("filesList");
		String path = (String) request.getAttribute("path");
	%>
	<c:forEach items="<%= filesList %>" var="filesInfo">
		<tr>
			<td><img src="<%= path %>${filesInfo.fileName}" height="200" class="myImg"></td>
			<td style="padding-right: 30px;" bgcolor="#ccebd6">
				<ul>
					<li>File Name: ${filesInfo.fileName}</li>
					<li>Caption: ${filesInfo.caption}</li>
					<li>Label: ${filesInfo.label}</li>
				</ul>
			</td>
			<td style="padding: 30px;" bgcolor="#ffb3b3">
				<form action="${pageContext.request.contextPath}/image-upload" method="post">
					Label: <input type="text" name="label" placeholder="Give a label..."><br><br>
					Caption: <input type="text" name="caption" placeholder="Give a caption..."><br><br>
					<input type="hidden" name="operation" value="updateDetails">
					<input type="hidden" name="fileId" value="${filesInfo.fileId}">
					<input type="submit" value="Update">
					<input type="reset" value="Reset">
				</form>
			</td>
			<td style="padding: 30px;" bgcolor="#d1b3ff">
				<form action="${pageContext.request.contextPath}/image-upload" method="post">
					<input type="hidden" name="operation" value="deleteImage">
					<input type="hidden" name="fileId" value="${filesInfo.fileId}">
					<input type="hidden" name="fileName" value="${filesInfo.fileName}">
					<input onclick="if(!confirm('Are You sure you want to delete this image ?')) return false" type="submit" value="Delete Image">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
<script src="js/scriptForModalImage.js"></script>
</body>
</html>