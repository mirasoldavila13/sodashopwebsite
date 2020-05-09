<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review List</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">Review List</h2>
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
				<th>ID</th>
				<th>Customer</th>
				<th>Soda ID</th>
				<th>Rating</th>
				<th>Headline</th>
				<th>Comment</th>
				<th>Review On</th>
				<th>Actions</th>
			</tr>
			<br />
			<c:forEach var="review" items="${listReviews}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${review.reviewId}</td>
					<td>${review.customer.customerId}</td>
					<td>${review.soda.sodaId}</td>
					<td>${review.rating}</td>
					<td>${review.headline}</td>
					<td>${review.comment}</td>
					<td>${review.reviewTime}</td>

					<td><a href="javascript:confirmDelete(${review.reviewId})">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:directive.include file="footer.jsp" />
	<script>
		function confirmDelete(reviewId) {
			if (confirm('Are you sure you want to delete review ' + reviewId
					+ '?')) {
				//if user presses ok, set the location property of the current window to the url of the servlet
				window.location = 'delete_review?id=' + reviewId;
			}
		}
	</script>
</body>

</html>