<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:import url="/include/header.jsp">
	<c:param name="title" value="Add User"/>
</c:import>

<!-- Header -->
    <header id="header" class="ex-header">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="white">Adding User</h1>
                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </header> <!-- end of ex-header -->
    <!-- end of header -->

    <!-- Add User Content -->
    <div class="ex-basic-2">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="text-container last">
                                <h3>Add any User</h3>
                                <p>Java is among the most in-demand programming languages on the job market, depending on whose numbers you look at.</p>
                                <p>Full Stack Java developer Practical Guide" introduces you to Java, JSP, Restful WS, and spring. In this course, you will be able to combine all the ways to connect to the database and learn how to make it in an informative and attractive way.</p>
                            </div> <!-- end of text container -->
                        </div> <!-- end of col-->
                        <div class="col-md-6">

                            <!-- Privacy Form -->
                            <div class="form-container">
                                <form id="addUserForm" data-toggle="validator" data-focus="false" action="<%= request.getContextPath() %>/operationController" method="post">
                                    <div class="form-group">
                                        <input type="text" class="form-control-input" id="pname" name="userName" required>
                                        <label class="label-control" for="pname">User name</label>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control-input" id="pemail" name="emailId" required>
                                        <label class="label-control" for="pemail">Email</label>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                     <div class="form-group">
                                       <input type="hidden" name="operation" value="addUser">
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="form-control-submit-button">ADD</button>
                                    </div>
                                    <div class="form-group">
                                        <button type="reset" class="form-control-submit-button">RESET</button>
                                    </div>
                                    <div class="form-message">
                                        <div id="pmsgSubmit" class="h3 text-center hidden"></div>
                                    </div>
                                </form>
                            </div> <!-- end of form container -->
                            <!-- end of privacy form -->

                        </div> <!-- end of col--> 
                    </div> <!-- end of row -->
                    <a class="btn-solid-reg" href="index.html">BACK</a>
                </div> <!-- end of col-->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of ex-basic-2 -->
    <!-- end of Add User content -->

<%@ include file="/include/footer.jsp" %>