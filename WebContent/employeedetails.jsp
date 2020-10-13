<%@page import="com.servlet.application.model.User"%>
<%@page import="com.servlet.application.dao.UserDAO"%>
<%@page import="com.servlet.application.controller.UserServlet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script>
//delete message box
function confirm_delete(){
	var d = confirm("Are you sure you want to delete?");
	if (d == true) {
	    return true;
	} else {
	   
	    event.preventDefault();
	}
}

</script>
</head>
<body>
<%  
 
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("username")==null){
	response.sendRedirect("login.jsp");

}



UserDAO userdao = new UserDAO();
List<User> users=userdao.getAllUsers();  

request.setAttribute("listUser",users);  
%> 
<div class="container text-center">
<a href="index.jsp"><input type="button" name="logout" value="Logout"> </a>
<h3 align="center">User Details Table</h3>

			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>

                     <table align="center" border="2px">
                 		<thead>
                            <tr>
                                <th>ID</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Contact Number</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <% for (User user : users) {%>
   							 <tr>
       						   <td><%=user.getId()%></td>
        					   <td><%=user.getUsername()%></td>
        					   <td><%=user.getPassword()%></td>
        					   <td><%=user.getEmail()%></td>
        					   <td><%=user.getAddress()%></td>
      						   <td><%=user.getContactNumber()%></td>
        					   
        					   <td><a href="edit?id=<%=user.getId()%>" ><input type="button" name="username" value="Update" ></a></td>
            					
            				   <td><a href="delete?id=<%=user.getId()%>"><input type="button" name="username" value="Delete" onclick="confirm_delete()"></a></td>
                            </tr>
                        <% } %>
                        </table>
                       </div>
                        


</body>
</html>