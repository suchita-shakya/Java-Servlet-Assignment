package com.servlet.application.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.application.dao.Logindao;
import com.servlet.application.dao.UserDAO;
import com.servlet.application.model.Employee;
import com.servlet.application.model.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Logindao logindao;
	
	 public void init() {
	        logindao = new Logindao();
	    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		
		UserDAO userdao = new UserDAO();
		
		try {
            if (logindao.validate(login)) {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                response.sendRedirect("employeedetails.jsp");
            } else {
            	
            	HttpSession session = request.getSession();
                System.out.println("invalid username");
                response.sendRedirect("index.jsp");
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
}
		
		 

