<%@page import="com.entity.ServiceOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.ServiceOrderDAOImpl"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Service</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body>
	
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-1">
	<h3 class="text-center text-primary">Your Order</h3>
	
		<table class="table table-striped mt-3">
  			<thead class="bg-primary text-white">
    			<tr>
      				<th scope="col">Order Id</th>
      				<th scope="col">Name</th>
      				<th scope="col">Service</th>
      				<th scope="col">Provider</th>
      				<th scope="col">Price</th>
      				<th scope="col">Payment Type</th>
    			</tr>
  			</thead>
  			<tbody>
	  			<%
	  			User user = (User)session.getAttribute("userobj");
	  			ServiceOrderDAOImpl dao = new ServiceOrderDAOImpl(DBConnect.getConnection());
	  			List<ServiceOrder> serviceList = dao.getService(user.getEmail());
	  			for(ServiceOrder service : serviceList) {
	  			%>
  				<tr>
      				<th scope="row"><%=service.getOrderId()%></th>
      				<td><%=service.getUserName()%></td>
      				<td><%=service.getServiceName()%></td>
      				<td><%=service.getProvider()%></td>
      				<td><%=service.getPrice()%></td>
      				<td><%=service.getPaymentType()%></td>
    			</tr>
	  			<%	
	  			}
	  			%>
  			</tbody>
		</table>
	</div>
</body>
</html>