<%@page import="com.entity.ServiceDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
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
<title>User : Old Service</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp" %>
	
	<c:if test="${not empty succMsg }">
		<div class="alert alert-success text-center">
		${succMsg}
		</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	
	<div class="container p-5">
		<table class="table table-striped">
  			<thead class="bg-primary text-white">
    			<tr>
      				<th scope="col">Service</th>
      				<th scope="col">Provider</th>
      				<th scope="col">Price</th>
      				<th scope="col">Category</th>
      				<th scope="col">Action</th>
    			</tr>
  			</thead>
  			<tbody>
  			
  			<%
  			User user = (User)session.getAttribute("userobj");
  			String email = user.getEmail();
  			
  			ServiceDAOImpl dao = new ServiceDAOImpl(DBConnect.getConnection());
  			List<ServiceDetails> list = dao.getServiceByOld(email, "Old");
  			%>
  			<%
  			for(ServiceDetails service : list) {
  			%>	
  			<tr>
      			<td><%=service.getServiceName()%></td>
      			<td><%=service.getProvider()%></td>
      			<td><%=service.getPrice()%></td>
      			<td><%=service.getServiceCategory()%></td>
      			<td><a href="delete_old_service?email=<%=email%>&&<%=service.getServiceId()%>" 
      				class="btn btn-sun btn-danger">Delete</a></td>
    		</tr>
  			<%
  			}
  			%>
  			</tbody>
		</table>
	</div>
</body>
</html>