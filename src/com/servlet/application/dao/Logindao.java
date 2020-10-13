package com.servlet.application.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servlet.application.model.Login;
import java.sql.Connection;

public class Logindao {
	public boolean validate(Login login) throws ClassNotFoundException {
        boolean status = false;
        java.sql.Connection conn =null;
        String sql="SELECT * FROM employee WHERE username = ? AND password = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
        	
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system",
                    "root", "");
        	
            

            // Step 2:Create a statement using connection object
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, login.getUsername());
           	preparedStatement.setString(2, login.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
           System.out.println("Sql Exception!!"+ e.getMessage());
        }
        return status;

	}
	
}

