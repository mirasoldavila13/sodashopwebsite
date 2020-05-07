a<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create New Customer</title>
			<link rel="stylesheet" href="../css/style.css">
			<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
			<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
		</head>
	<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">
			<c:if test="${user != null}">Edit User</c:if>
			<c:if test="${user == null}">Create New User</c:if>
		</h2>
	</div>

	<div align="center">
		<c:if test="${user != null}">
			<form action="update_user" method="post" id="userForm">
				<input type="hidden" name="userId" value=${user.userId}>
		</c:if>

		<c:if test="${user == null}">
			<form action="create_user" method="post" id="userForm">
		</c:if>
		<table class="form">
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="text" id="email" name="email" size="20" value="${user.email}"/></td>
			</tr>
			<tr>
				<td align="right">Full Name:</td>
				<td align="left"><input type="text" id="fullName"
					name="fullName" size="20" value="${user.fullName}"/></td>
			</tr>

			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="password" id="password"
					name="password" size="20" value="${user.password}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<button type="submit">Save</button>
					<button onclick="javascript:history.go(-1);">Cancel </button>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
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