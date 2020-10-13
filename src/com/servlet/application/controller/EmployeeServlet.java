package com.servlet.application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.servlet.application.dao.EmployeeDao;
import com.servlet.application.model.Employee;
import com.servlet.application.model.User;
import com.servlet.application.network.SendMail;

import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeedao;
	private User user;
	
	public void init() {
		employeedao = new EmployeeDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//for sending email to the user who registered.
		String emailFrom="shakyasuchita90@gmail.com";
        String pass="101@shakya";
        String subject="Test for email verification";
        String message="hello verified.";
        String to = request.getParameter("email");
        
      
        
        SendMail.send(to,subject,message,emailFrom, pass);
        System.out.println(request.getParameter("email"));
        System.out.println("Mail send successfully");
       

		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String contactNumber = request.getParameter("contactnumber");
		
		
		Employee employee = new Employee();
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setContactNumber(contactNumber);
		
		try {
			employeedao.registerEmployee(employee);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		response.sendRedirect("login.jsp");
		
		
		
		
	}
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setContentType("text/html");
	       PrintWriter out= response.getWriter();
	       //System.out.println(request.getParameter("username"));
	       
	       //System.out.println(request.getParameter("username"));
	       //System.out.println(request.getParameter("email"));
	       //System.out.println(request.getParameter("password"));
	       //System.out.println(request.getParameter("address"));
	       //System.out.println(request.getParameter("contact"));
	       Verifier verify = new Verifier();
	       int checker = verify.verifyUser(request.getParameter("username"));
	       if(checker==0){
	           out.println("Username is already taken");
	           out.println("<a href=\" RegistrationForm.jsp \">Return to registration</a>");
	       }
	       else{
	            int checker2= verify.verifyMail(request.getParameter("email"));
	            if (checker2==0){
	                out.println("This email is already in use");
	                out.println("<a href=\" RegistrationForm.jsp \">Return to registration</a>");              
	            }
	            else{
	                WriteFile write= new WriteFile();
	                write.writer(request.getParameter("username"), request.getParameter("email"), request.getParameter("password"), request.getParameter("address"), request.getParameter("contact"));
	                SendEmail sender = new SendEmail();
	                sender.send(request.getParameter("email"));
	            }//write.writer("a", "b", "c", "d", "e");
	       //out.println("Line");
	       }
	}*/

}
