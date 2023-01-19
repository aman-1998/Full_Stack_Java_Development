<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="personal.learning.entity.Users" %>

<c:import url="/include/header.jsp">
	<c:param name="title" value="List of Users"/>
</c:import>

<!-- Header -->
    <header id="header" class="ex-header">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="white">Listing All Users</h1>
                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </header> <!-- end of ex-header -->
    <!-- end of header -->
    
    <!-- Privacy Content -->
    <div class="ex-basic-2">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                	<div class="text-container last">
                        <h3>List of Users</h3>
                    </div> <!-- end of text container -->
                	<div style="overflow-x:auto;">
	                    <table id="myTable">
	                    	<tr>
	                    		<th>User Id</th>
	                    		<th onclick="sortTable(1)">User Name (click to sort)</th>
	                    		<th onclick="sortTable(2)">Email Id (click to sort)</th>
	                    		<th>Update</th>
	                    		<th>Delete</th>
	                    	</tr>
	                    	<% 
	                    		List<Users> listOfUsers = (List<Users>)request.getAttribute("listOfUsers"); 
	                    		
	//                      		for(int i=0; i<listUsers.size(); i++) {
	//                      			out.print("<tr>");
	//                     				out.print("<td>"+listUsers.get(i).getUserId()+"</td>");
	//                      			out.print("<td>"+listUsers.get(i).getUserName()+"</td>");
	//                      			out.print("<td>"+listUsers.get(i).getEmailId()+"</td>");
	//                      			out.print("</tr>");
	//                      		}
	                    	%>
	                    	<c:forEach items="<%= listOfUsers %>" var="user">
	                    		<tr>
	                    			<td>${user.userId}</td>
	                    			<td>${user.userName}</td>
	                    			<td>${user.emailId}</td>
	                    			<td>
	                    				<c:url var="updateUser" value="operationController">
	                    					<c:param name="operation" value="updateUser"></c:param>
	                    					<c:param name="userId" value="${user.userId}"></c:param>
	                    					<c:param name="userName" value="${user.userName}"></c:param>
	                    					<c:param name="emailId" value="${user.emailId}"></c:param>
	                    				</c:url>
	                    				<a href="${updateUser}"><button style="border: none; border-radius: 7px; background-color: #ffbd50; padding: 5px 10px;">UPDATE</button></a>
		                    			<!-- Below line can also be used instead of using url tag -->
		                    			<%-- <a href="${pageContext.request.contextPath}/operationController?operation=updateUser&userId=${user.userId}&userName=${user.userName}&emailId=${user.emailId}"><button style="border: none; border-radius: 7px; background-color: #ffbd50; padding: 5px 10px;">UPDATE</button></a> --%>
	                    		   	</td>
	                    		   	<td>
	                    		   		<c:url var="deleteUser" value="operationController">
	                    		   			<c:param name="operation" value="deleteUser"></c:param>
	                    					<c:param name="userId" value="${user.userId}"></c:param>
	                    					<c:param name="userName" value="${user.userName}"></c:param>
	                    					<c:param name="emailId" value="${user.emailId}"></c:param>
	                    				</c:url>
	                    				<a onclick="if(!confirm('Are You sure you want to delete this record ?')) return false" href="${deleteUser}"><button style="border: none; border-radius: 7px; background-color: #ffbd50; padding: 5px 10px;">DELETE</button></a>
	                    		   		<!-- Below line can also be used instead of using url tag -->
	                    		   		<%-- <a onclick="if(!confirm('Are You sure you want to delete this record ?')) return false" href="${pageContext.request.contextPath}/operationController?operation=deleteUser&userId=${user.userId}&userName=${user.userName}&emailId=${user.emailId}"><button style="border: none; border-radius: 7px; background-color: #ffbd50; padding: 5px 10px;">DELETE</button></a> --%>
	                    		   	</td>
	                    		</tr>
	                    	</c:forEach>
	                    </table>
                    </div>
                </div> <!-- end of col-->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of ex-basic-2 -->
    <!-- end of privacy content -->
    
<%@ include file="/include/footer.jsp" %>

<script>

function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("myTable");
  switching = true;
  //Set the sorting direction to ascending:
  dir = "asc"; 
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      /*check if the two rows should switch place,
      based on the direction, asc or desc:*/
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          //if so, mark as a switch and break the loop:
          shouldSwitch= true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          //if so, mark as a switch and break the loop:
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      //Each time a switch is done, increase this count by 1:
      switchcount ++;      
    } else {
      /*If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again.*/
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
</script>