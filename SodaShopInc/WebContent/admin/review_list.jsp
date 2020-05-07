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
				<th>Soda</th>
				<th>Rating</th>
				<th>Headline</th>
				<th>Customer</th>
				<th>Review On</th>
				<th>Actions</th>
			</tr>
			<br />
			<c:forEach var="review" items="${reviewList}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${review.reviewId}</td>
					<td>${soda.name}</td>
					<td>${soda.rating}</td>
					<td>${review.headline}</td>
					<td>${review.comment}</td>
					<td>${review.review_time}</td>

					<td><a href="edit_category?id=${review.reviewId}">Edit</a>
						&nbsp; <a href="javascript:confirmDelete(${review.reviewId})">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>

</html>