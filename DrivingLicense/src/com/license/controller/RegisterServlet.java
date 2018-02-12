package com.license.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.license.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.PreparedStatement preStatement;
    private java.sql.Statement statement;
    private java.sql.Connection con;
    private String url = "jdbc:mysql://localhost:3306/";
    private  String dbUser = "root";
	private  String dbpassword = "root";
	private String dbName = "DrivingLicense";
    static int status=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
        String userName = request.getParameter("uname");
        String emailId = request.getParameter("eid");
        String password = request.getParameter("pass");
        String confirmPassword = request.getParameter("cpass");
        String dob = request.getParameter("dob");
        String mobileNo = request.getParameter("mno");
        String addr = request.getParameter("address");
        String testDate = request.getParameter("td");
        String gender = request.getParameter("gender");
        
        User user = new User();
        user.setName(name);
        user.setUsername(userName);
        user.setEmailId(emailId);
        user.setPassword(password);
        user.setDOB(dob);
        user.setMobileNum(mobileNo);
        user.setAddress(addr);
        user.setTestDate(testDate);
        user.setGender(gender);
        
        if (name.isEmpty() || userName.isEmpty() || emailId.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || dob.isEmpty() || mobileNo.isEmpty() || addr.isEmpty() || testDate.isEmpty() || gender.isEmpty() || name == null || 
        	userName == null || emailId == null || password == null || confirmPassword == null || dob == null || mobileNo == null || addr == null || testDate == null || gender == null) {
        	String Error = "Failed to register";
			request.setAttribute("registererror", Error);
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		} else {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("userName", userName);
	        
	        	try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	                this.con = DriverManager.getConnection(url+dbName, dbUser, dbpassword);   
	                String createTblQuery = "Create table if not exists USERTABLE "
	                		+ "(id INT(64) NOT NULL AUTO_INCREMENT UNIQUE,"
	                		+ "name VARCHAR(100),"
	                		+ "userName VARCHAR(100),"
	                		+ "email VARCHAR(100),"
	                		+ "password VARCHAR(50),"
	                		+ "dob VARCHAR(100),"
	                		+ "mobileNumber VARCHAR(100),"
	                		+ "address VARCHAR(100),"
	                		+ "testDate VARCHAR(100),"
	                		+ "gender VARCHAR(20), PRIMARY KEY(id))";
	                statement = this.con.createStatement();
	                statement.executeUpdate(createTblQuery);
	            } 
	            catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            } catch (InstantiationException e) {
	    			e.printStackTrace();
	    		} catch (IllegalAccessException e) {
	    			e.printStackTrace();
	    		}

	    		String registerQuery = "INSERT INTO USERTABLE (name, userName, email, password,"
	    				+ "dob, mobileNumber, address,"
	    				+ "testDate, gender) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    		try {
	    			preStatement = con.prepareStatement(registerQuery);
	    			preStatement.setString(1, user.getName());
	    			preStatement.setString(2, user.getUsername());
	    			preStatement.setString(3, user.getEmailId());
	    			preStatement.setString(4, user.getPassword());
	    			preStatement.setString(5, user.getDOB());
	    			preStatement.setString(6, user.getMobileNum());
	    			preStatement.setString(7, user.getAddress());
	    			preStatement.setString(8, user.getTestDate());
	    			preStatement.setString(9, user.getGender());
	    			status = preStatement.executeUpdate();
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		} 
	        	
				if (status > 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("payment.jsp");
					dispatcher.forward(request, response);
				} else {
					String Error = "Failed to register";
					request.setAttribute("registererror", Error);
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.include(request, response);
				}
				
		}
	}

}
