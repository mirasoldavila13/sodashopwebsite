<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Soda Shop Incorporated</title>
			<link rel="stylesheet" href="../css/style.css">
		</head>
		<body>
		
		<jsp:directive.include file="header.jsp"/>
			
			<div class="center">
		<table class="soda">
			<tr>
				<td colspan="3" align="left">
					<p id="soda-name">${soda.name}</p>
					 by <span id="manufacture">${soda.manufacture}</span>
				</td>
			</tr>
			<tr>
				<td rowspan="2">
					<img class="soda-large" src="data:image/jpg;base64,${soda.base64Image}" />
				</td>
				<td valign="top" align="left">
					Rating ****
				</td>
				<td valign="top" rowspan="2" width="20%">
					<h2>$${soda.price}</h2>
					<br/><br/>
					<button id="buttonAddToCart">Add to Cart</button>
				</td>
			</tr>
			<tr>
				<td id="description">
					${soda.description}
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><h2><a id="reviews">Customer Reviews</a></h2></td>
				<td colspan="2" align="center">
					<button id="buttonWriteReview">Write a Customer Review</button>
				</td>
			</tr>
			<tr><td>&nbsp;&nbsp;&nbsp;</td></tr>
		</table>
	</div>
	</body>
</html>