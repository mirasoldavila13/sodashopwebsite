<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Soda Shop Incorporated</title>
			
		</head>
		<body>
			<jsp:directive.include file="header.jsp"/>

			<div align="center">
				<br /><br />
				<h2>New Soda's</h2>
				<div align="center">
		<c:forEach items="${listNewSoda}" var="soda">
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
					<jsp:directive.include file="soda_rating.jsp" />				
				</div>
				<div><i>by ${soda.manufacture}</i></div>
				<div><b>$${soda.price}</b></div>
			</div>
			
		</c:forEach>
	</div>
			<div class="next-row">
			<h2>Best-Selling Sodas:</h2>
			<c:forEach items="${listBestSellingSodas}" var="soda">
				<jsp:directive.include file="soda_group.jsp" />
			</c:forEach>			
		</div>
		<div class="next-row">
			<h2>Most-favored Soda:</h2>
			<c:forEach items="${listFavoredSoda}" var="soda">
				<jsp:directive.include file="soda_group.jsp" />
			</c:forEach>			
		</div>
			<jsp:directive.include file="footer.jsp"/>
			
		</body>
</html>