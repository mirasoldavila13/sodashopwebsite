a<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create New Soda</title>
		<link rel="stylesheet" href="../css/style.css">
		<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	</head>
	
	<body>
	
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">
			<c:if test="${soda != null}">Edit Soda</c:if>
			<c:if test="${soda == null}">Create New Soda</c:if>
		</h2>
	</div>

	<div align="center">
		<c:if test="${soda != null}">
			<form action="update_soda" method="post" onSubmit="return validateFormInput()">
				<input type="hidden" name="sodaId" value=${soda.sodaId}>
		</c:if>

		<c:if test="${soda == null}">
			<form action="create_soda" method="post" onSubmit="return validateFormInput()">
		</c:if>
		<table class="form">
			
			<tr>
				<td align="right">Category:</td>
				<td align="left">
					<input type="text" id="category" name="category" size="20" value="${soda.category.name}"/>
				</td>
			</tr>
			<tr>
				<td align="right">Name</td>
				<td> 
					<input type="text" id="name" name="name" size="20" value="${soda.name}"/>
				</td>
			</tr>
			<tr>
				<td align="right">Manufacture</td>
				<td> 
					<input type="text" id="manufacture" name="manufacture" size="20" value="${soda.manufacture}"/>
				</td>
			</tr>
			<tr>
				<td align="right">Publish Date:</td>
				<td> 
					<input type="text" id="publishDate" name="publishDate" size="20" value="${soda.publishDate}"/>
				</td>
			</tr>
			<tr>
				<td align="right">Image:</td>
				<td> 
					<input type="text" id="bookImage" name="bookImage" size="20" value="${soda.base64Image}"/>
				</td>
			</tr>
			
			<tr>
				<td align="right">Price:</td>
				<td><input type="text" id="price" name="price" size="20" value="${soda.price}"/></td>
			</tr>
			<tr>
				<td align="right">Description:</td>
				<td align="left">
					<textarea rows="5" cols="50" name="description" id="description">${soda.description}</textarea>
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /> <input type="button" value="Cancel"
					onclick="javascript:history.go(-1);" /></td>
			</tr>
		</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
		function validateFormInput(){
			var nameField = document.getElementById("name");	//this a reference to name
			
			if(nameField.value.length == 0){
				alert("Soda is required");
				nameField.focus();
				return false;
			}
			return true;
		}

	</script>
</html>