<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Manage Categories</title>
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>
			<div align="center">
				<h1>Category Management</h1>
				<a href="category_form.jsp">Create New Category</a>
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
						<th>Name</th>
						<th>Actions</th>
					</tr>
					<br />
					<c:forEach var="category" items="${listCategories}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${category.categoryId}</td>
						<td>${category.name}</td>
						
						<td> 
							<a href="edit_category?id=${category.categoryId}">Edit</a> &nbsp;
							<a href="javascript:confirmDelete(${category.categoryId})">Delete</a>
						 </td>
					</tr>
					</c:forEach>
			</table>
			</div>
			<jsp:directive.include file="footer.jsp"/>
			
			<script>
				function confirmDelete(categoryId){

				if(confirm('Are you sure you want to delete category ' + categoryId + '?')){
					//if user presses ok, set the location property of the current window to the url of the servlet
					window.location = 'delete_category?id=' + categoryId;
					}
				}


		</script>
	</body>
	
</html>