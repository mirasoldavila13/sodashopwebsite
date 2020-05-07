a<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create New Soda</title>
		<link rel="stylesheet" href="../css/style.css">
		<link rel="stylesheet" href="../css/jquery-ui.min.css">
		<link rel="stylesheet" href="../css/richtext.min.css">	
		<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
		
		<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="../js/jquery.richtext.min.js"></script>
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
			<form action="update_soda" method="post" id="sodaForm" enctype="multipart/form-data">			<form action="update_soda" method="post" onSubmit="return validateFormInput()">

				<input type="hidden" name="sodaId" value=${soda.sodaId}>
		</c:if>

		<c:if test="${soda == null}">
			<form action="create_soda" method="post" id="sodaForm" enctype="multipart/form-data">
		</c:if>
		<table class="form">
			<tr>	
				<td>Category:</td>
				<td>
					<select name="category">
						<c:forEach items="${listCategory}" var="category">
							<c:if test="${category.categoryId eq soda.category.categoryId}">
								<option value="${category.categoryId}" selected>
							</c:if>
							<c:if test="${category.categoryId ne soda.category.categoryId}">
								<option value="${category.categoryId}">
							</c:if>							
								${category.name}
							</option>
						</c:forEach>
					</select>
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
				<td align="right">Image:</td>
				<td> 
					<input type="file" id="sodaImage" name="sodaImage" size="20"/> </br>
					<img  id="thumbnail" alt="Image Preview" src="data:image/jpg;base64,${soda.base64Image}"/>
				</td>
			</tr>
			
			<tr>
				<td align="right">Price:</td>
				<td><input type="text" id="price" name="price" size="20" value="${soda.price}"/></td>
			</tr>
			<tr>
				<td align="right">Description:</td>
				<td >
					<textarea rows="5" cols="50" name="description" id="description" >${soda.description}</textarea>
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save" />
					 <input type="button" value="Cancel" onclick="javascript:history.go(-1);" />
				</td>
			</tr>
		</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<<script type="text/javascript">

	$(document).ready(function() {
	
		
		$('#sodaImage').change(function() {
			showImageThumbnail(this);
		});
		
		
		$("#sodaForm").validate({
			rules: {
				category: "required",
				name: "required",
				manufacture: "required",
		
				<c:if test="${soda == null}">
					sodaImage: "required",
				</c:if>
				
				price: "required",
				description: "required",
				quantity: "required",
				amountheld: "required",
				Stock Units: "required",
			},
			
			messages: {
				category: "Please select a category for the soda",
				name: "Please enter name of the soda",
				manufacture: "Please enter manufacture of the soda",
				sodaImage: "Please choose an image of the soda",
				price: "Please enter price of the soda",
				description: "Please enter description of the soda",
				quantity: "Please enter the quantitiy of the soda",
				amountheld: "Please enter the total amount of soda",
				units: "Please enter the stock units of soda",
				
			},
		});
		
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
	
	function showImageThumbnail(fileInput) {
		var file = fileInput.files[0];
		
		var reader = new FileReader();
		
		reader.onload = function(e) {
			$('#thumbnail').attr('src', e.target.result);
		};
		
		reader.readAsDataURL(file);
	}
</script>
</html>