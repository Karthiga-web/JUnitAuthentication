<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
</head>
<body>
	<div align="center">
		<form id="update"
			action="${pageContext.request.contextPath}/junit5Test/update"
			method="post" modelAttribute="user">
			<table style="with: 50%">
				<tr>
					<td>Id</td>
					<td><input type="number" name="id"></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastname" /></td>
				</tr>
				<tr>
					<td>Email Address</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" /></td>
				</tr>
			</table>
			<input type="submit" value="Update" />
		</form>
	</div>
</body>
</html>