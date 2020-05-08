<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Orders</title>
			<link rel="stylesheet" href="../css/style.css">
			<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
			<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>
			<div align="center">
				<h2 class="pageheading">Order Management</h2>
				<a href="new_soda">Create New Order</a>
			</div>
			<c:if test="${message != null}">
			<div align="center">
				<h4 class="message">${message}</h4>
			</div>
			</c:if>
			
			<div align="center">
				<table border="1">
					<tr>
						<th>Index</th>
						<th>Order ID</th>
						<th>Soda ID</th>
						<th>Quantity</th>
						<th>Total Amount</th>
						<th>Order Date</th>
					</tr>
					<--! var might need to be changed to what 'category' it is -->
					<c:forEach var="order" items="${listAllByCustomerId}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${order.orderId}</td>
						<td>${order.sodaId}</td>
						<td>${order.quantity}</td>
						<td>${order.total}</td>
						<td>${order.orderDate}</td>
					</tr>
					</c:forEach>
			</table>
			</div>
			<jsp:directive.include file="footer.jsp"/>
	</body>
	
</html>