<%@page import="com.entity.User"%>
<%@page import="com.entity.ServiceDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.ServiceDAOImpl"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.DB.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Provider: Index</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.back-img{
	background: url("img/internet-services.jpg");
	height: 50vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
	background-repeat: no-repeat;
}
.crd-ho:hover{
	background-color: #acb3de;
}

</style>

</head>
<body style="background-color: #e3e6e2;">

	<%
	User user = (User)session.getAttribute("userobj"); 
	%>

	<%@include file="all_component/navbar.jsp" %>
	<div class="container-fluid back-img">
		<h2 class="text-center text-success">Internet services</h2>
	</div>
	
	
	<!-- Start Recent service -->
	
	<div class="container">
		<h3 class="text-center">Recent services </h3>
		<div class="row">
		<%
		ServiceDAOImpl dao2 = new ServiceDAOImpl(DBConnect.getConnection());
		List<ServiceDetails> list2 = dao2.getRecentServices();
		for(ServiceDetails service : list2) {
		%>
		<div class="col-md-3">
			<div class="card crd-ho">
				<div class="card-body text-center">
					<img alt="" src="service/<%=service.getPhotoName()%>" 
						style="width: 150px;height: 200px" 
						class="img-thumblin">
					<p><%=service.getServiceName()%></p>
					<p><%=service.getProvider() %></p>
					<p>
					
					<%
					if(service.getServiceCategory().equals("Old")) {
					%>
					Service categorie: <%=service.getServiceCategory()%></p>	
					<div class="row text-center" style="width: 150px;height: 200px">
						<a href="view_services.jsp?sid=<%=service.getServiceId()%>" 
							class="btn btn-success btn-sm ml-5">View Details</a> 
						<a href="" class="btn btn-danger btn-sm ml-1"><%=service.getPrice()%> 
							<i class="fa-sharp fa-solid fa-dollar-sign"></i></a>
					</div>	
					<%
					} else {
					%>	
					Service categorie: <%=service.getServiceCategory() %></p>
					<div class="row text-center" style="width: 150px;height: 200px">
						<% 
						if(user == null) {
						%>
						<a href="login.jsp" class="btn btn-danger btn-sm ml-2" ><i class="fa-solid fa-plus"></i> Add</a>
						<%
						} else {
						%>
						<a href="cart?serviceid=<%=service.getServiceId()%>&&userid=<%=user.getId()%>" class="btn btn-danger btn-sm ml-2" ><i class="fa-solid fa-plus"></i> Add</a>
						<%
						}
						%>
							<a href="view_services.jsp?sid=<%=service.getServiceId()%>" 
								class="btn btn-success btn-sm ml-1">View Details</a> 
							<a href="" class="btn btn-danger btn-sm ml-1"><%=service.getPrice()%> <i 
								class="fa-sharp fa-solid fa-dollar-sign"></i></a>	
					</div>
					<%
					}
					%>	
				</div>
			</div>
		</div>	
		<%
		}
		%>
			
		</div>
		<div class="text-centor mt-1">
		<a href="all_recent_services.jsp" class="btn btn-danger btn-sm text-white">View All</a>	
		</div>
		
	</div>
	<!-- End Recent service -->
	
	<hr>

	<!-- Start New service -->
	
	<div class="container">
		<h3 class="text-center">New services </h3>
		<div class="row">
			
			<%
			ServiceDAOImpl dao = new ServiceDAOImpl(DBConnect.getConnection());
			List<ServiceDetails> list = dao.getNewService();
			for(ServiceDetails service : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="service/<%=service.getPhotoName()%>" style="width: 150px;height: 200px" 
							class="img-thumblin">
						<p><%=service.getServiceName() %></p>
						<p><%=service.getProvider() %></p>
						<p>Service categories: <%=service.getServiceCategory() %></p>
						<div class="row">
							<% 
							if(user == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-2" ><i class="fa-solid fa-plus"></i> Add</a>
							<%
							} else {
							%>
							<a href="cart?serviceid=<%=service.getServiceId()%>&&userid=<%=user.getId()%>" class="btn btn-danger btn-sm ml-2" ><i class="fa-solid fa-plus"></i> Add</a>
							<%
							}
							%>
							
							<a href="view_services.jsp?sid=<%=service.getServiceId()%>" class="btn btn-success btn-sm ml-1">View Details</a> 
							<a href="" class="btn btn-danger btn-sm ml-1"><%=service.getPrice()%> 
							<i class="fa-sharp fa-solid fa-dollar-sign"></i></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
	
		</div>
		<div class="text-centor mt-1">
		<a href="all_new_services.jsp" class="btn btn-danger btn-sm text-white">View All</a>	
		</div>
		
	</div>
	<!-- End New service -->

	<hr>

	<!-- Start Old service -->
	
	<div class="container">
		<h3 class="text-center">Old services </h3>
		<div class="row">
		
		
			<%
			ServiceDAOImpl dao3 = new ServiceDAOImpl(DBConnect.getConnection());
			List<ServiceDetails> list3 = dao2.getOldServices();
			for(ServiceDetails service : list3) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="service/<%=service.getPhotoName()%>" 
							style="width: 150px;height: 200px" 
							class="img-thumblin">
						<p><%=service.getServiceName()%></p>
						<p><%=service.getProvider() %></p>
						<p><%=service.getServiceCategory()%></p>
						<div class="row">
							<a href="view_services.jsp?sid=<%=service.getServiceId()%>" 
								class="btn btn-success btn-sm ml-1">View Details</a> 
							<a href="" class="btn btn-danger btn-sm ml-1"><%=service.getPrice()%> 
							<i class="fa-sharp fa-solid fa-dollar-sign"></i></a>
						</div>
					
					</div>
				</div>
			</div>	
			<%
			}
			%>
	
		</div>
		<div class="text-centor mt-1">
		<a href="all_old_services.jsp" class="btn btn-danger btn-sm text-white">View All</a>	
		</div>
		
	</div>
	<!-- End Old service -->




	<%@include file="all_component/footer.jsp" %>
	
</body>
</html>