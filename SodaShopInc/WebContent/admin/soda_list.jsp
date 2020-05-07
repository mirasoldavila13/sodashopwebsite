<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Manage Soda</title>
			<link rel="stylesheet" href="../css/style.css">
			<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
			<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>
			<div align="center">
				<h2 class="pageheading">Soda Management</h2>
				<a href="new_soda">Create New Soda</a>
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
						<th>Name</th>
						<th>Manufacture</th>
						<th>Image</th>
						<th>Category</th>
						<th>Price</th>
						<th>Last Updated</th>
						<th>Action</th>
					</tr>
					<br />
					<c:forEach var="soda" items="${listSoda}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${soda.sodaId}</td>
						<td>${soda.name}</td>
						<td>${soda.manufacture}</td>
						<td>
						<img src="data:image/jpg;base64,${soda.base64Image}" width="84" height="110" />
						</td>
						<td>${soda.category.name}</td>
						<td>${soda.price}</td>
						<td>${soda.lastUpdateTime}</td>
					
						<td> 
							<a href="edit_soda?id=${soda.sodaId}">Edit</a> &nbsp;
							<a href="javascript:confirmDelete(${soda.sodaId})">Delete</a>
						 </td>
					</tr>
					</c:forEach>
			</table>
			</div>
			<jsp:directive.include file="footer.jsp"/>
			
			<script>
				function confirmDelete(sodaId){

				if(confirm('Are you sure you want to delete soda ' + sodaId + '?')){
					//if user presses ok, set the location property of the current window to the url of the servlet
					window.location = 'delete_soda?id=' + sodaId;
					}
				}


		</script>
	</body>
	
</html>