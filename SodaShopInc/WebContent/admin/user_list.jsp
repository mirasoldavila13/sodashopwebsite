<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Users Management</title>
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>
			<div align="center">
				<h1>Users Management</h1>
				<a href="user_form.jsp">Create New User</a>
			</div>
			<c:if test="${message != null}">
			<div align="center">
				<h4><i>${message}</i></h4>
			</div>
			</c:if>
			
			<div align="center">
				<table border="1">
					<tr>
						<th>Index</th>
						<th>ID</th>
						<th>Email</th>
						<th>Full Name</th>
						<th>Actions</th>
					</tr>
					<br />
					<c:forEach var="user" items="${listUsers}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${user.userId}</td>
						<td>${user.email}</td>
						<td>${user.fullName}</td>
						<td> 
							<a href="edit_user?id=${user.userId}">Edit</a> &nbsp;
							<a href="javascript:confirmDelete(${user.userId})">Delete</a>
						 </td>
					</tr>
					</c:forEach>
			</table>
			</div>
			<jsp:directive.include file="footer.jsp"/>
			
			<script>
				function confirmDelete(userId){

				if(confirm('Are you sure you want to delete user ' + userId + '?')){
					//if user presses ok, set the location property of the current window to the url of the servlet
					window.location = 'delete_user?id=' + userId;
					}
				}


		</script>
	</body>
	
</html>