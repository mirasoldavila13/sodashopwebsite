<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Review</title>
</head>
<body>

	<div align="center">
		<h2>Customer Review</h2>
		<form id="CustomerReview" action="post" method="post">
			<table>
				<tr>
					<td>Rating:</td>
					<td><select name="rating">
							<option value="1">1 Poor</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10 Excellent</option>
					</select></td>
					<!-- <td><input type="number" name="rating" min="1" max="10" size="1" ></td> -->
				</tr>
				<tr>
					<td>Headline:</td>
					<td><input type="text" name="headline" size="60"></td>
				</tr>
				<tr>
					<td>Comments:</td>
					<td><input type="text" name="comment" size="60"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Submit Review</button>
			</table>
		</form>

	</div>

</body>
</html>