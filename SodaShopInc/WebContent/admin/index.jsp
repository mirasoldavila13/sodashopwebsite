<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Soda Shop Incorporated Administration</title>
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>
			<div align="center">
				<h1>Administration Dashboard</h1>
			</div>
			<div align="center">
				<hr width="60%"/>
				<h2>Quick Actions:</h2>
				<b>
				<a href="user_form.jsp">New User</a> &nbsp;
				<a href="create_customer">New Customer</a> &nbsp;
				<a href="create_category">New Category</a> &nbsp;
				<a href="create category">New Soda</a> &nbsp;
				<a href="inqury_form">Inventory Inqury Form</a> &nbsp;
				</b>
			</div>
			<div align="center">
				<hr width="60%"/>
				<h2>Recent Sales: </h2>
			</div>
			<div align="center">
				<hr width="60%"/>
				<h2>Recent Reviews: </h2>
			</div>
			<div align="center">
				<hr width="60%"/>
				<h2>Statistics: </h2>
			</div>
			<jsp:directive.include file="footer.jsp"/>
			
	</body>
</html>