<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Users" %>

<%@ include file="/include/header.jsp" %>


<!-- Header -->
    <header id="header" class="ex-header">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="white">This is Details title</h1>
                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </header> <!-- end of ex-header -->
    <!-- end of header -->
    
 <!-- Breadcrumbs -->
    <div class="ex-basic-1">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumbs">
                        <span>List of Users:-</span>
                    </div> <!-- end of breadcrumbs -->
                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of ex-basic-1 -->
    <!-- end of breadcrumbs -->


    <!-- Privacy Content -->
    <div class="ex-basic-2">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <table border="1">
                    	<tr>
                    		<th>User Id</th>
                    		<th>User Name</th>
                    		<th>Email Id</th>
                    	</tr>
                    	<% 
                    		List<Users> listUsers = (List<Users>)request.getAttribute("listUsers"); 
                    		
//                      		for(int i=0; i<listUsers.size(); i++) {
//                      			out.print("<tr>");
//                     				out.print("<td>"+listUsers.get(i).getUserId()+"</td>");
//                      			out.print("<td>"+listUsers.get(i).getUserName()+"</td>");
//                      			out.print("<td>"+listUsers.get(i).getEmailId()+"</td>");
//                      			out.print("</tr>");
//                      		}
                    	%>
                    	<c:forEach items="<%= listUsers %>" var="user">
                    		<tr>
                    			<td>${user.userId}</td>
                    			<td>${user.userName}</td>
                    			<td>${user.emailId}</td>
                    		</tr>
                    	</c:forEach>
                    </table>
                </div> <!-- end of col-->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of ex-basic-2 -->
    <!-- end of privacy content -->


<%@ include file="/include/footer.jsp" %>