<%@page import="com.entity.ServiceDetails"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.ServiceDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #acb3de;">
	<%@include file="all_component/navbar.jsp" %>
	
	<%
	int sid = Integer.parseInt(request.getParameter("sid"));
	ServiceDAOImpl dao = new ServiceDAOImpl(DBConnect.getConnection());
	ServiceDetails service = dao.getServiceById(sid);
	
	%>
	
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img src="service/<%=service.getPhotoName()%>" style="height: 150px; width: 150px"><br>
				<h4 class="mt-2">Service:<span class="text-success"> <%=service.getServiceName()%></span></h4>
				<h4>Provider:<span class="text-success"> <%=service.getProvider()%></span></h4>
				<h4>Category:<span class="text-success"> <%=service.getServiceCategory()%></span></h4>
			</div>
			
			<div class="col-md-6 text-center p-5 border bg-white">
				<h2><%=service.getServiceName()%></h2>
				
				<%
				if("Old".equals(service.getServiceCategory())) {
				%>
				<h5 class="text-primary">Contact Us</h5>
				<h5 class="text-primary">
					<i class="fa-solid fa-envelope"></i> EMail: <%=service.getEmail()%></h5>
				<%
				}
				%>
				
				<div class="row">
					<div class="col-md-4 text-danger text-center p-2">
						<p></p>
					</div>
					<div class="col-md-4 text-danger text-center p-2"></div>
					<div class="col-md-4 text-danger text-center p-2"></div>
				</div>
				
				<% 
				if("Old".equals(service.getServiceCategory())) {
				%>
				<div class="row">
					<a href="index.jsp" class="btn btn-success"><i class="fa-solid fa-plus"></i> See Other Services</a>
					<a href="" class="btn btn-warning"><i class="fa-sharp fa-solid fa-dollar-sign"></i> 200</a>
				</div>
				<% 
				} else {
				%>
				<div class="row">
					<a href="" class="btn btn-primary"><i class="fa-solid fa-plus"></i> Add</a>
					<a href="" class="btn btn-warning"><i class="fa-sharp fa-solid fa-dollar-sign"></i> 200</a>
				</div>
				<%	
				}
				%>
				
			</div>
		</div>
	</div>
</body>
</html>