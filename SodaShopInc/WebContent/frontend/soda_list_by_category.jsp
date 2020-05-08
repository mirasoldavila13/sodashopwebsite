<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Soda Shop Incorporated</title>
			<link rel="stylesheet" href="../css/style.css">
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>

			<div align="center">
		<h2>${category.name}</h2>
	</div>
	
	<div align="center">
		<c:forEach items="${listSoda}" var="soda">
			<div style="display: inline-block">
				<div>
					<a href="view_soda?id=${soda.sodaId}">
						<img class="soda-small" src="data:image/jpg;base64,${soda.base64Image}" />
					</a>
				</div>
				<div>
					<a href="view_soda?id=${soda.sodaId}">
						<b>${soda.name}</b>
					</a>
				</div>
				<div>
		
				</div>
				<div><i>by ${soda.manufactor}</i></div>
				<div><b>$${soda.price}</b></div>
			</div>
			
		</c:forEach>
	</div>
			<jsp:directive.include file="footer.jsp"/>
			
		</body>
</html>