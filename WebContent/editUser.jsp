<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.servlet.application.dao.UserDAO"%>
<%@page import="com.servlet.application.model.User"%>
<%@page import="java.util.List"%>
        <html>

        <head>
            <title>Edit User </title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>
       
      <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                      <%  
                      
                      UserDAO userdao = new UserDAO();
                      int id = Integer.parseInt(request.getParameter("id"));
          	          User user = userdao.selectUser(id);
          	          //User user = new User();

  
					%>  
					<h3>Edit New User</h3>

                        

                        
                        <form action="<%=request.getContextPath()%>/update" method ="post">
                        <input type="hidden" name="id" value="<%=user.getId()%>" />
                        <fieldset class="form-group">
                            <label>Username</label> <input type="text"  class="form-control" name="username" value="<%=user.getUsername()%>" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Password</label> <input type="password"   class="form-control" name="password" value="<%=user.getPassword()%>"  required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User Email</label> <input type="text" class="form-control" name="email"value="<%=user.getEmail()%>" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User Address</label> <input type="text"  class="form-control" name="address" value="<%=user.getAddress()%>" >
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Contact Number</label> <input type="text"  class="form-control" name="contactnumber" value="<%=user.getContactNumber()%>" >
                        </fieldset>
						
                        <button type="submit" class="btn btn-success">Save</button>
                        
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>