<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Login Application</title>
</head>
<body>
	<div align="center">
		<h2>Enter your Login Credentials!</h2>
		<div style="color: red">${message}</div>
		<form id="find"
			action="${pageContext.request.contextPath}/junit5Test/find"
			method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" required/></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>