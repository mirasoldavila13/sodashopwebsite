<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Manage Categories</title>
			<link rel="stylesheet" href="../css/style.css">
			<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
			<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>
			<div align="center">
				<h2 class="pageheading">Category Management</h2>
				<a href="category_form.jsp">Create New Category</a>
			</div>
			<c:if test="${message != null}">
			<div align="center">
				<h4 class="message">${message}</h4>
			</div>
			</c:if>
			
			<div align="center">
				<table border="1">
					<tr>
						<th>Index</th>
						<th>ID</th>
						<th>Image</th>
						<th>Name</th>
						<th>Manufacture</th>
						<th>Category</th>
						<th>Category</th>
						<th>Price</th>
						<th>Last Updated</th>
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