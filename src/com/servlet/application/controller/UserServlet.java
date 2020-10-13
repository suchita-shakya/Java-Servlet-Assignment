package com.servlet.application.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.application.dao.UserDAO;
import com.servlet.application.model.Employee;
import com.servlet.application.model.User;
import java.util.List;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userdao ;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        
    }
    public void init() {
       this.userdao = new UserDAO();
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}	
		


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getServletPath();
		userdao = new UserDAO();
		

        try {
            switch (action) {
                case "/delete":
                    deleteUser(request, response);
                    break;
                
                case "/edit":
                	showUpdateForm(request,response);
                	break;
                
                case"/new":
                	newUser(request,response);
                    break;
                case "/add":
    				addUser(request,response);
    				break;
    			
    			case "/update":
    				updateUser(request, response);
    				break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
        
    	private void listUser(HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException, IOException, ServletException {
        	        List <User > listUser = userdao.getAllUsers();
        	        
        	        request.setAttribute("listUser", listUser);
        	        RequestDispatcher dispatcher = request.getRequestDispatcher("employeedetails.jsp");
        	        dispatcher.forward(request, response);
        	    }
    	
    	
        
        private void deleteUser(HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException, IOException {
        	        int id = Integer.parseInt(request.getParameter("id"));
        	        userdao.deleteUser(id);
        	        response.sendRedirect("employeedetails.jsp");

        	    }
        private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException, ServletException, IOException {
        	        int id = Integer.parseInt(request.getParameter("id"));
        	        User existingUser = userdao.selectUser(id);
        	        RequestDispatcher dispatcher = request.getRequestDispatcher("editUser.jsp");
        	        request.setAttribute("listUser", existingUser);
        	        dispatcher.forward(request, response);

        	    }
        private void updateUser(HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException, IOException {
        			int id = Integer.parseInt(request.getParameter("id"));
        	        String username= request.getParameter("username");
        	        String password= request.getParameter("password");
        	        String email = request.getParameter("email");
        	        String address = request.getParameter("address");
        	        String contactnumber = request.getParameter("contactnumber");
        	        
        	        User user = new User( username,password, email, address,contactnumber);
        	        userdao.updateUser(user,id);
        	        response.sendRedirect("employeedetails.jsp");
        	    }
        private void newUser(HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException,ServletException, IOException {
        	        RequestDispatcher dispatcher = request.getRequestDispatcher("newUser.jsp");
        	        dispatcher.forward(request, response);
        	        
        	    }
       private void addUser(HttpServletRequest request, HttpServletResponse response)
        	    throws SQLException, IOException {
        	        String username = request.getParameter("username");
        	        String password = request.getParameter("password");
        	        String email = request.getParameter("email");
        	        String address = request.getParameter("address");
        	        String contactnumber = request.getParameter("contactnumber");
        	        User user = new User(username,password, email, address, contactnumber );
        	        try {
        	  			userdao.addUser(user);
        	  		}catch(Exception e){
        	  			e.printStackTrace();
        	  		}
        	        response.sendRedirect("employeedetails.jsp");
        	    }
        
		
	}
	
        
        
        


        	    
    
	

	

