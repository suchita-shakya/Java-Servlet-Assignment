package com.servlet.application.dao;
import java.util.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.servlet.application.model.User;

public class UserDAO {
	private static final String getAllUsers = "select * from employee";
    private static final String deleteUser = "delete from employee where id = ?;";
    private static final String selectUserById = "select id,username,password,email,address,contactnumber from employee where id =?";
    private static final String updateUser = "update employee set username = ?,password= ?,email =?, address=?,contactnumber=? where id = ?;";
    private static final String addUserQuery =  "INSERT into employee"+" (username, password, email, address, contactnumber) " +
            "VALUES (?,?,?,?,?);";
    
    
    
	 public static Connection getConnection(){  
	        Connection conn=null;  
	        try{  
	            Class.forName("com.mysql.cj.jdbc.Driver");  
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system",
	                    "root", ""); 
	        }catch(Exception e){System.out.println(e);
	        }  
	        return conn;  
	    }  
	 
	 public List <User> getAllUsers() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < User > users = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(getAllUsers);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String username = rs.getString("username");
	                String password = rs.getString("password");
	                String email = rs.getString("email");
	                String address = rs.getString("address");
	                String contactnumber = rs.getString("contactnumber");
	                users.add(new User(id, username, password, email, address, contactnumber ));
	            }
	        } catch (SQLException e) {
	            System.out.println("Sql exception" +e);
	        }
	        return users;
	    }

	    public boolean deleteUser(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); 
	        	PreparedStatement statement = connection.prepareStatement(deleteUser);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	    public boolean updateUser(User user,int id) throws SQLException {
	       boolean rowUpdated;
	        try {
	        	Connection connection = getConnection(); 
	        	PreparedStatement statement = connection.prepareStatement(updateUser);
	            statement.setString(1, user.getUsername());
	            statement.setString(2, user.getPassword());
	            statement.setString(3, user.getEmail());
	            statement.setString(4, user.getAddress());
	            statement.setString(5, user.getContactNumber());
	            statement.setInt(6, id);

	            rowUpdated = statement.executeUpdate()>0;
	        }catch(SQLException ex) {
	        	System.out.println("error occured while updating "+ex.getMessage());
	        	rowUpdated=false;
	        }
	        return rowUpdated;
	    }
	    
	    public User selectUser(int id) throws SQLException{
	        User user = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(selectUserById);) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                String username = rs.getString("username");
	                String password = rs.getString("password");
	                String email = rs.getString("email");
	                String address = rs.getString("address");
	                String contactNumber = rs.getString("contactNumber");
	                user = new User(id, username,password, email, address,contactNumber);
	            }
	        } 
	        return user;
	        
	    }
	    public int addUser(User user) throws SQLException {
	        System.out.println(addUserQuery);
	        int result=0;
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(addUserQuery)) {
	            preparedStatement.setString(1, user.getUsername());
	            preparedStatement.setString(2, user.getPassword());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, user.getAddress());
	            preparedStatement.setString(5, user.getContactNumber());
	            System.out.println(preparedStatement);
	            result=preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	        	System.out.println("Sql exception" +e);
	        }
	        return result;
	    }
}
	 
	 
	    
