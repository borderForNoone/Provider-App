<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Add Services</title>
<%@include file="allCss.jsp" %>
</head>
<body style="background-color: #f0f2f0;">
	<%@include file="navbar.jsp" %>
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp"/>
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Add Services</h4>
						<c:if test="${not empty succMsg}">
							<p class="text-center text-success">${succMsg }</p>
							<c:remove var="succMsg" scope="session"/>
						</c:if>
						
						<c:if test="${not empty failedMsg}">
							<p class="text-center text-danger">${failedMsg }</p>
							<c:remove var="failedMsg" scope="session"/>
						</c:if>
						
						<form action="../add_services" method="post"
							enctype="multipart/form-data">
							
							<div class="form-group">
								<label for="exampleInputEmail1">Service Name</label> <input 
									name="serviceName" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedly="emailHelp">
							</div>
							
							<div class="form-group">
								<label for="exampleInputEmail1">Service Provider</label> <input 
									name="provider" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedly="emailHelp">
							</div>
							
							<div class="form-group">
								<label for="exampleInputEmail1">Price</label> <input 
									name="price" type="number" class="form-control"
									id="exampleInputPassword1">
							</div>
							
							<div class="form-group">
								<label for="inputState">Service Categories</label> <select
									id="inputState" name="categories" class="form-control">
									<option selected>--select--</option>
									<option value="New">New Service</option>
								</select> 	
							</div>
							
							<div class="form-group">
								<label for="inputState">Service Status</label> <select
									id="inputState" name="status" class="form-control">
									<option selected>--select--</option>
									<option value="Active">Active</option>
									<option value="New">Inactive</option>
								</select> 	
							</div>
							
							<div class="form-group">
								<label for="exampleFormControlField1">Upload Photo</label> <input
									name="serviceImage" type="file" class="form-control-file"
									id="exempleFormControlFie1">
							</div>
							
							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div style="margin-top: 197px;">
		<%@include file="footer.jsp"%></div>	
		
</body>
</html>