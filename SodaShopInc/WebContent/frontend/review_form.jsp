a<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write a Review</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<form id="reviewForm" action="submit_review" method="post">
			<table class="form">

				<tr>
					<td><h2>Your Reviews</h2></td>
					<td>&nbsp;</td>
					<td><h2>${loggedCustomer.fullname}</h2></td>
				</tr>
				<tr>
					<td align="right">Name:</td>
					<td align="left"><input type="text" id="fullName"
						name="fullName" size="20" value="${customer.fullName}" /></td>
				</tr>
				<tr>
					<td><span id="sodaName">${soda.name}</span><br /> <img
						src="data:image/jpg;base64,${soda.base64Image}" /></td>
				</tr>
				<tr>
					<td align="right">Rating:</td>
					<td align="left"><input type="text" id="rating" name="rating"
						size="20" value="${review.rating}"></td>
				</tr>
				<tr>
					<td align="right">Headline:</td>
					<td align="left"><input type="text" id="headline"
						name="headline" size="50" value="${review.headline}" /></td>
				</tr>
				<tr>
					<td align="right">Comment:</td>
					<td align="left"><textarea rows="5" cols="50" name="comment"
							id="comment">${review.comment}</textarea></td>
				</tr>


				<tr>
					<td>&nbsp;</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<button type="submit">Save</button>
						<button onclick="javascript:history.go(-1);">Cancel</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>