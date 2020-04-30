<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Create New Customer</title>
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>
			<div align="center">
				<h1>Create New Customer</h1>
			</div>
			<div align="center">					
			<form action="create_user" method="post" onSubmit="return validateFormInput()">
					<table class="form">
						<tr>
							<td align="right">Email:</td>
							<td align="left">
								<input type="text" id="email" name="email" size="20"/>
							</td>
						</tr>
						<tr>
							<td align="right">Full Name:</td>
							<td align="left"><input type="text" id="fullName" name="fullNames" size="20"/>
							</td>
						</tr>
					
						<tr>
							<td align="right">Password:</td>
							<td align="left"><input type="password" id="password" name="password" size="20""></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
					
						<tr>
							<td colspan="2" align="center"> 
								<input type="submit" value="Save"/>
								<input type="button" value="Cancel" onclick="javascript:history.go(-1);"/>
							</td>
						</tr>
					</table>
				</form> 
			</div>
			<jsp:directive.include file="footer.jsp"/>
	</body>
	<script type="text/javascript">
		function validateFormInput(){
			var emailField = document.getElementById("email");	//this a reference to email
			var nameField = document.getElementById("fullName");
			var passwordField = document.getElementById("password");
			
			if(emailField.value.length == 0){
				alert("Email is required");
				emailField.focus();
				return false;
			}
			if(nameField.value.length == 0){
				alert("Full Name is required");
				nameField.focus();
				return false;
			}
			if(passwordField.value.length == 0){
				alert("Password is required");
				passwordField.focus();
				return false;
			}	
			return true;

		}




	</script>
</html>