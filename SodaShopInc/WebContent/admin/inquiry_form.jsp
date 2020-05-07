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
		<form id="inqueryForm" action="submit_inquery" method="post">
			<table class="form">

				<tr>
					<td><h2>Your Inquiry</h2></td>
					<td>&nbsp;</td>
					<td><h2>admin</h2></td>
				</tr>
				<tr>
					<td><span id="sodaId">Soda ID</span><br /></td>
					<td align="left"><input type="text" id="sodaId" name="sodaId"
						size="20" value="${soda.sodaId}">
				</tr>

				<tr>
					<td><span id="sodaName">${soda.name}</span><br /> <img
						src="data:image/jpg;base64,${soda.base64Image}" /></td>
				</tr>
				<tr>
					<td align="right">Soda Category:</td>
					<td align="left"><input type="text" id="category" name="category"
						size="20" value="${soda.category}"></td>
				</tr>
				<tr>
					<td align="right">Price:</td>
					<td align="left"><input type="text" id="price"
						name="headline" size="50" value="${soda.price}" /></td>
				</tr>
				<tr>
					<td align="right">Manufacturer:</td>
					<td align="left"><input type="text" id="manufacturer"
						name="headline" size="50" value="${soda.manufacturer}" /></td>
				</tr>
				<tr>
					<td align="right">Stock Units:</td>
					<td align="left"><input type="text" id="stockUnits"
						name="headline" size="50" value="${soda.stockUnits}" /></td>
				</tr>
				<tr>
					<td align="right">Amount Held:</td>
					<td align="left"><input type="text" id="amountHeld"
						name="headline" size="50" value="${soda.amountHeld}" /></td>
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