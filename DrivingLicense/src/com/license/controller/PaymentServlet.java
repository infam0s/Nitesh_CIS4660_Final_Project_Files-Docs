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
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
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
    public PaymentServlet() {
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

		String cardnum = request.getParameter("number");
        String cardname = request.getParameter("name");
        String expirydate = request.getParameter("date");
        
        User user = new User();
        user.setCardNum(cardnum);
        user.setCardName(cardname);
        user.setExpiryName(expirydate);
        
        if (cardnum.isEmpty() || cardname.isEmpty() || expirydate.isEmpty() || 
        	cardnum == null || cardname == null || expirydate == null) {
        	String Error = "Failed to make a payment";
			request.setAttribute("paymenterror", Error);
			RequestDispatcher rd = request.getRequestDispatcher("payment.jsp");
			rd.include(request, response);
		} else {
			
			HttpSession httpSession = request.getSession();
			String users = (String) httpSession.getAttribute("userName");
			
				try {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            this.con = DriverManager.getConnection(url+dbName, dbUser, dbpassword);
		            String createTblQuery = "Create table if not exists PAYMENTINFO "
	                		+ "(id INT(64) NOT NULL AUTO_INCREMENT UNIQUE,"
	                		+ "name VARCHAR(100),"
	                		+ "cardNo VARCHAR(100),"
	                		+ "cardName VARCHAR(100),"
	                		+ "expiryDate VARCHAR(100), PRIMARY KEY(id))";
	                statement = this.con.createStatement();
	                statement.executeUpdate(createTblQuery);
		        } 
		        catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        } catch (SQLException e) {
		           e.printStackTrace();
		        } catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String paymentQuery = "INSERT INTO PAYMENTINFO (name, cardNo, cardName, expiryDate) VALUES(?, ?, ?, ?)";
				try {
					preStatement = con.prepareStatement(paymentQuery);
					preStatement.setString(1, users);
					preStatement.setString(2, user.getCardNum());
					preStatement.setString(3, user.getCardName());
					preStatement.setString(4, user.getExpiryName());
					status = preStatement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				
				if (status > 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
					dispatcher.forward(request, response);
				} else {
					String Error = "Failed to make the payment";
					request.setAttribute("paymenterror", Error);
					RequestDispatcher rd = request.getRequestDispatcher("payment.jsp");
					rd.include(request, response);
				}
		}
	}

}
