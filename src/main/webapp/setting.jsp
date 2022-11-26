<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
a{
text-decoration: none;
color: black;
}
a:hover {
	text-decoration: none;
}
</style>

</head>
<body style="background-color: #e3e6e2;">
	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp"/>
	</c:if>

	<%@include file="all_component/navbar.jsp" %>
	
	<div class="container">
	<h3 class="text-center">Hello, ${userobj.name}</h3>	
			<div class="col-md-6">
				<a href="old_service.jsp" >
					<div class="card">
						<div class="card-body text-center ">
							<h4>Old Service</h4>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-6">
				<a href="edit_profile.jsp" >
					<div class="card">
						<div class="card-body text-center ">
							<div class="text-primary">
								<i class="fa-solid fa-pen fa-2x"></i>
							</div>
							<h4>Edit Profile</h4>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-6">
				<a href="order.jsp" >
					<div class="card">
						<div class="card-body text-center text">
							<div class="text-primary">
								<i class="fa-solid fa-folder fa-2x"></i>
							</div>
							<h4>My Order</h4>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-6">
				<a href="helpline.jsp" >
					<div class="card">
						<div class="card-body text-center text">
							<div class="text-primary">
								<i class="fa-solid fa-user-circle fa-2x"></i>
							</div>
							<h4>Help</h4>
							<p>24/7</p>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp" %>
</body>
</html>