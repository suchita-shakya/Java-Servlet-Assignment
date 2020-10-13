package com.servlet.application.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import com.servlet.application.model.Employee;


public class EmployeeDao {
	public int registerEmployee(Employee employee)throws ClassNotFoundException {
		String sql = "INSERT into employee"+" (username, password, email, address, contactnumber) " +
                "VALUES (?,?,?,?,?)";
		int result=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
        
        
        try {
        	
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system",
                    "root", "");
            
            
            
            
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, employee.getUsername());
           	preparedStatement.setString(2, employee.getPassword());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setString(5,employee.getContactNumber() );
            
            
           
            //
            
           
            
            	//System.out.println(preparedStatement);
            
                
                
                	result=preparedStatement.executeUpdate();
                    conn.close();
                
            
            	
   
            
            }catch (SQLException se) {
                System.out.println("Exception occurred when carrying out SQL operation. " + se.getMessage());
            }
        
        	return result;
	}
}
	
	
        	
        	
    









