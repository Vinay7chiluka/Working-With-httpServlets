package org.servletchaining.app;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/GmailVerification")
public class GmailVerification extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException ,IOException{
		String email =req.getParameter("mail");
		//jdbc code
		String url="jdbc:mysql://localhost:3306?user=root&password=1234";
		String query="select * from advancejava.accountdetails where email=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection(url);
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			//Servlet chaining
			if(rs.next()) {
				//retrive the data from database
				String  password=rs.getString("password");
				
				//to access session created by jEE container
				HttpSession session=req.getSession();
				System.out.println("session object accessed....");
				
				//store data in a session object
				session.setAttribute("pwd",password);
				System.out.println("password stores inside a session");
				
				//to Provide time intervel
				session.setMaxInactiveInterval(10);
				
				//display password.html
				RequestDispatcher dispatcher=req.getRequestDispatcher("Password.html");
				dispatcher.include(req, resp);
			}
			else
			{
				//display email.html
				RequestDispatcher diapatcher=req.getRequestDispatcher("Email.html");
				diapatcher.include(req, resp);
			}
			cn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
