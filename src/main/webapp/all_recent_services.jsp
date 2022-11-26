<%@page import="com.entity.User"%>
<%@page import="com.entity.ServiceDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.ServiceDAOImpl"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.DB.DBConnect" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Recent Services</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #acb3de;
}
</style>
</head>
<body>
	<%
	User user = (User)session.getAttribute("userobj"); 
	%>
	<%@include file="all_component/navbar.jsp" %>
	
	<c:if test="${not empty failedMsg}">
		<div class="alert alert-danger text-center" role="alert">${failedMsg}</div>
		<c:remove var="failedMsg" scope="session"/>
	</c:if>
	
	<c:if test="${not empty succMsg}">
		<div class="alert alert-success" role="alert">${succMsg}</div>
		<c:remove var="succMsg" scope="session"/>
	</c:if>
	
	<div class="container-fluid">
		<div class="row p-3">
				<%
				ServiceDAOImpl dao2 = new ServiceDAOImpl(DBConnect.getConnection());
				List<ServiceDetails> list2 = dao2.getAllRecentServices();
				for(ServiceDetails service : list2) {
				%>
				<div class="col-md-3">
					<div class="card crd-ho mt-2">
						<div class="card-body text-center">
							<img alt="" src="service/<%=service.getPhotoName()%>" 
								style="width: 150px; height: 200px" 
								class="img-thumblin">
							<p><%=service.getServiceName()%></p>
							<p><%=service.getProvider() %></p>
							<p>
							
							<%
							if(service.getServiceCategory().equals("Old")) {
							%>
							Service categorie: <%=service.getServiceCategory()%></p>	
							<div class="row text-center" style="width: 150px;height: 200px">
								<a href="view_services.jsp?sid=<%=service.getServiceId()%>" class="btn btn-success btn-sm ml-5">View Details</a> 
								<a href="" class="btn btn-danger btn-sm ml-1"><%=service.getPrice()%> <i class="fa-sharp fa-solid fa-dollar-sign"></i></a>
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

								
								<a href="view_services.jsp?sid=<%=service.getServiceId()%>" class="btn btn-success btn-sm ml-1">View Details</a> 
								<a href="" class="btn btn-danger btn-sm ml-1"><%=service.getPrice()%> <i class="fa-sharp fa-solid fa-dollar-sign"></i></a>
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
	</div>	
</body>
</html>