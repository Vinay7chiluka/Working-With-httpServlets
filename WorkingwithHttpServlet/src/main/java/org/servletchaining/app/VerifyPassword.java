package org.servletchaining.app;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VerifyPassword")
public class VerifyPassword extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException ,IOException{
		//fetch data
		String mobile=req.getParameter("mb");
		String password=req.getParameter("pwd");
		
		//jdbc Code
		String url="jdbc:mysql://localhost:3306?user=root&password=1234";
		String query="select * from advancejava.accountdetails where MobileNumber=? and Password=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection	connection=DriverManager.getConnection(url);
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, mobile);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("LogoutPage.html");
			dispatcher.include(req, resp);
		}
		else
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("LoginPage.html"); 
			dispatcher.include(req, resp);
		}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
