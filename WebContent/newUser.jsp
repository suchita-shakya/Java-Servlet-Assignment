<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.servlet.application.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New User</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h3 align="center">Please fill the form to add user.</h3>
<div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                    <h3>Add New User</h3>
					   <form action="<%=request.getContextPath()%>/add" method="post">
                       <% User user = new User(); %>
						<fieldset class="form-group">
                            <label>Username</label> <input type="text"  class="form-control" name="username"  required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Password</label> <input type="password"   class="form-control" name="password"   required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User Email</label> <input type="text" class="form-control" name="email" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User Address</label> <input type="text"  class="form-control" name="address" >
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Contact Number</label> <input type="text"  class="form-control" name="contactnumber"  >
                        </fieldset>
						
                        <button type="submit" class="btn btn-success">Save</button>
                        
				 </form>
				</div>
			</div>
</body>
</html>