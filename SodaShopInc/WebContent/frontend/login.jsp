<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Customer Login</title>	
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>
		
			<div align="center">
				<h2>Customer Login</h2>
				<form id="LoginForm" action="" method="post">
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
		<script type="text/javascript">

	$(document).ready(function() {
		$("#loginForm").validate({
			rules: {
				email: {
					required: true,
					email: true
				},
		
				password: "required",
			},
			
			messages: {
				email: {
					required: "Please enter email",
					email: "Please enter an valid email address"
				},
				
				password: "Please enter password"
			}
		});

	});
</script>	
	</html>