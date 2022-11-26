<%@page import="com.entity.ServiceDetails"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.ServiceDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %> 
<%@page import="com.DAO.ServiceDAOImpl"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Edit Service</title>
<%@include file="allCss.jsp" %>
</head>
<body style="background-color: #f0f2f0;">
	<%@include file="navbar.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Add Services</h4>
						
						
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						ServiceDAOImpl dao = new ServiceDAOImpl(DBConnect.getConnection());
						ServiceDetails service = dao.getServiceById(id);
						%>
						
						<form action="../edit_services" method="post">
							<input type="hidden" name="id" value="<%=service.getServiceId()%>">
							<div class="form-group">
								<label for="exampleInputEmail1">Service Name</label> <input 
									name="serviceName" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedly="emailHelp" value="<%=service.getServiceName()%>">
							</div>
							
							<div class="form-group">
								<label for="exampleInputEmail1">Service Provider</label> <input 
									name="provider" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedly="emailHelp" value="<%=service.getProvider()%>">
							</div>
							
							<div class="form-group">
								<label for="exampleInputEmail1">Price</label> <input 
									name="price" type="number" class="form-control"
									id="exampleInputPassword1" value="<%=service.getPrice()%>">
							</div>
							
							<div class="form-group">
								<label for="inputState">Service Status</label> <select
									id="inputState" name="status" class="form-control">
									<% 
									if("Active".equals(service.getStatus())) { 
									%>
										<option value="Active">Active</option>
										<option value="Inactive">Inactive</option>
									<% 
									} else { 
									%>
										<option value="Inactive">Inactive</option>
										<option value="Active">Active</option>
									<% 
									}
									%>											
								</select> 	
							</div>		
							<button type="submit" class="btn btn-primary">Update</button>
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