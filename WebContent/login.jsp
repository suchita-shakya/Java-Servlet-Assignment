<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<form action="<%=request.getContextPath()%>/login" method="post">
<div align="center">
<h3>Login Page</h3>
<table>
<tr><td>Username:</td><td><input type="text" name="username" required="required"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password" required="required"></td></tr>
<tr><td><input type="submit" value="Login"></td><td><a href="register.jsp">Register</a></td></tr>
</table>
</div>
</form>
</body>
</html>