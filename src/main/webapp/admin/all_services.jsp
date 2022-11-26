<%@page import="com.entity.ServiceDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.ServiceDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Services</title>
<%@include file="allCss.jsp" %>
</head>
<body>
	<%@include file="navbar.jsp" %>
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp"/>
	</c:if>
	<h3 class="text-center">Hello Admin</h3>
	
	<c:if test="${not empty succMsg}">
		<h5 class="text-center text-success">${succMsg }</h5>
		<c:remove var="succMsg" scope="session"/>
	</c:if>
						
	<c:if test="${not empty failedMsg}">
		<h5 class="text-center text-danger">${failedMsg }</h5>
		<c:remove var="failedMsg" scope="session"/>
	</c:if>
	
	<table class="table table-striped">
  		<thead>
    		<tr>
    			<th scope="col">ID</th>
      			<th scope="col">Image</th>
      			<th scope="col">Service</th>
      			<th scope="col">Provider</th>
      			<th scope="col">Price</th>
      			<th scope="col">Categories</th>
      			<th scope="col">Status</th>
      			<th scope="col">Action</th>
    		</tr>
  		</thead>
  		<tbody>
  		<%
  		ServiceDAOImpl dao = new ServiceDAOImpl(DBConnect.getConnection());
  		List<ServiceDetails> list = dao.getAllServices();
  		for(ServiceDetails service : list) {
  		%>
  		<tr>
      			<td><%=service.getServiceId() %></td>
      			<td><img src="../service/<%=service.getPhotoName()%>" 
      				style="width: 50px; height: 50px;"></td>
      			<td><%=service.getServiceName()%></td>
      			<td><%=service.getProvider()%></td>
      			<td><%=service.getPrice()%></td>
      			<td><%=service.getServiceCategory()%></td>
      			<td><%=service.getStatus()%></td>
      			<td>
      			<a href="edit_services.jsp?id=<%=service.getServiceId()%>" class="btn btn-sm btn-primary"><i 
      				class="fa-solid fa-pen"></i> Edit</a> 
      			<a href="../deleteService?id=<%=service.getServiceId() %>" class="btn btn-sm btn-danger"><i 
      				class="fa-solid fa-trash"></i> Delete</a>
      			</td>
    	</tr>
  		<%	
  		}
  		%>
  		
  		</tbody>
	</table>
	
	<div style="margin-top: 520px;">
		<%@include file="footer.jsp"%></div>
	
</body>
</html>