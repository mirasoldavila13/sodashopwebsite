<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
=======
>>>>>>> adminLogin
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
<<<<<<< HEAD
			<title>Customer Login</title>
=======
			<title>Customer Login</title>	
>>>>>>> adminLogin
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>
		
			<div align="center">
<<<<<<< HEAD
				<h2>Customer Login</h2>				
=======
				<h2>Customer Login</h2>
<<<<<<< HEAD
>>>>>>> adminLogin
				<form id="LoginForm" action="login" method="post">
=======
				<form id="LoginForm" action="" method="post">
>>>>>>> adminLogin
					<table>
						<tr>
							<td>Email:</td>
							<td><input type="text" name="email" id="email" size="20"/></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password" id="password" size="20"/></td>
						</tr>
						<tr>
							<td colspan="2" align="center"> 
								<button type="submit">Login</button>
							</td>
						</tr>						
					</table>
				</form>
			</div>
			<jsp:directive.include file="footer.jsp"/>
		</body>
	</html>