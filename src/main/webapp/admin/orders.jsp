<%@page import="com.entity.ServiceOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.ServiceOrderDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Orders</title>
<%@include file="allCss.jsp" %>
</head>
<body>
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp"/>
	</c:if>
	<%@include file="navbar.jsp" %>
	<h3 class="text-center">Hello Admin</h3>
	
	<table class="table table-striped">
  		<thead class="bg-primary text-white">
    		<tr>
      			<th scope="col">Order Id</th>
      			<th scope="col">Name</th>
      			<th scope="col">EMail</th>
      			<th scope="col">Address</th>
      			<th scope="col">Phone No</th>
      			<th scope="col">Service</th>
      			<th scope="col">Provider</th>
      			<th scope="col">Price</th>
      			<th scope="col">Payment type</th>
    		</tr>
  		</thead>
  		<tbody>
	  		<%
	  		ServiceOrderDAOImpl dao = new ServiceOrderDAOImpl(DBConnect.getConnection());
	  		List<ServiceOrder> serviceList = dao.getAllOrder();
	  		for(ServiceOrder service : serviceList) {
	  		%>
  			<tr>
      			<th scope="row"><%=service.getOrderId()%></th>
      			<td><%=service.getUserName()%></td>
      			<td><%=service.getEmail()%></td>
      			<td><%=service.getFullAddress()%></td>
      			<td><%=service.getPhno()%></td>
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
	
	<div style="margin-top: 520px;">
		<%@include file="footer.jsp"%></div>
	
</body>
</html>