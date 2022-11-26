<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.UserDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Users</title>
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
      			<th scope="col">Name</th>
      			<th scope="col">Email</th>
      			<th scope="col">Phno</th>
      			<th scope="col">Adress</th>
      			<th scope="col">Landmark</th>
      			<th scope="col">City</th>
      			<th scope="col">State</th>
      			<th scope="col">Pincode</th>
    		</tr>
  		</thead>
  		<tbody>
  		<%
  		UserDAOImpl dao = new UserDAOImpl(DBConnect.getConnection());
  		List<User> list = dao.getAllUsers();
  		for(User user : list) {
  	  	%>
  	  		<tr>
  	      		<td><%=user.getId() %></td>
  	      		<td><%=user.getName() %></td>
  	      		<td><%=user.getEmail()%></td>
  	      		<td><%=user.getPhno()%></td>
  	      		<td><%=user.getAddress()%></td>
  	      		<td><%=user.getLandmark()%></td>
  	      		<td><%=user.getCity()%></td>
  	      		<td><%=user.getState()%></td>
  	      		<td><%=user.getPincode()%></td>
  	      		<td>
  	      		<a href="../deleteUser?id=<%=user.getId() %>" class="btn btn-sm btn-danger"><i 
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