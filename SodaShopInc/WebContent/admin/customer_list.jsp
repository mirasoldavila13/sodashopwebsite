<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Manage Customers</title>
			<link rel="stylesheet" href="../css/style.css">
			<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
			<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>
			<div align="center">
				<h2 class="pageheading">Customer Management</h2>
				<a href="customer_form.jsp">Create New Customer</a>
			</div>
			<c:if test="${message != null}">
			<div align="center">
				<h4 class="message">${message}</h4>
			</div>
			</c:if>
			
			<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>E-mail</th>
				<th>Full Name</th>
				<th>City</th>
				<th>Country</th>
				<th>Registered Date</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="customer" items="${listCustomer}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${customer.customerId}</td>
				<td>${customer.email}</td>
				<td>${customer.fullname}</td>
				<td>${customer.city}</td>
				<td>${customer.country}</td>
				<td>${customer.registerDate}</td>
				<td>
					<a href="edit_customer?id=${customer.customerId}">Edit</a> &nbsp;
					<a href="javascript:confirmDelete(${customer.customerId})" id="${customer.customerId}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
			<jsp:directive.include file="footer.jsp"/>
			
			<script>
				function confirmDelete(customerId){

				if(confirm('Are you sure you want to delete customer ' + customerId + '?')){
					//if user presses ok, set the location property of the current window to the url of the servlet
					window.location = 'delete_customer?id=' + customerId;
					}
				}


		</script>
	</body>
	
</html>