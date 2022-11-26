<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>    
<!DOCTYPE html>
<head>
<html>
<meta charset="ISO-8859-1">
<title>Admin: Home</title>
<%@include file="allCss.jsp" %>
<style type="text/css">
a{
text-decoration: none;
color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}

</style>
</head>
<body>
	<%@include file="navbar.jsp" %>
	
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp"/>
	</c:if>

	<div class="container">
		<div class="row p-5">
			<div class="col-md-3">
				<a href="add_services.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-regular fa-plus fa-3x"></i><br>
							<h4>Add Services</h4>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-3">
				<a href="all_services.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-magnifying-glass fa-3x"></i><br>
							<h4>All Services</h4>
						</div>
					</div>
				</a>	
			</div>
			
			<div class="col-md-3">
				<a href="all_users.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-magnifying-glass fa-3x"></i><br>
							<h4>All Users</h4>
						</div>
					</div>
				</a>	
			</div>
			
			<div class="col-md-3">
				<a href="orders.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-folder fa-3x"></i><br>
							<h4>Orders</h4>
						</div>
					</div>
				</a>	
			</div>
		
			<div class="col-md-3">
				<a data-bs-toggle="modal" data-bs-target="#staticBackdrop">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-right-from-bracket fa-3x"></i><br>
							<h4>Logout</h4>
						</div>
					</div>
				</a>
			</div>
		
		
		</div>
	
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" 
	 	data-bs-keyboard="false" tabindex="-1" 
	 	aria-labelledby="staticBackdropLabel" aria-hidden="true">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<h5 class="modal-title" id="staticBackdropLabel"></h5>
        			<button type="button" class="btn-close" data-bs-dismiss="modal" 
        				aria-label="Close"></button>
      			</div>
      			<div class="modal-body">
      	  			<div class="text-center">
      	  	  			<h4>Do You want logout?</h4>
      	  	  			<button type="button" class="btn btn-secondary" 
      	  	  	  			data-bs-dismiss="modal">Close</button>
          	  			<a href="../logout" type="button" class="btn btn-primary text-white">Logout</a>
      	  			</div>
      		    </div>
      	 	    <div class="modal-footer"></div>
    		</div>
  		</div>
	</div>
	<!-- end logout modal -->
	
	<div style="margin-top: 520px;">
		<%@include file="footer.jsp"%></div>
	
</body>
</html>