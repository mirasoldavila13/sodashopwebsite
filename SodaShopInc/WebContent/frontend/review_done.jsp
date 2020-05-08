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
	<jsp:directive.include file="header.jsp"/>

	<div align="center">
		<form id="reviewDone" action="review_done" method="post">
				<tr>
					<td><h2>Your Review Has Been Posted! Thank You ${loggedCustomer.fullname}</h2></td>
				</tr>
				<tr>
					<img src="../images/smile.png"/><br/>
				</tr>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>