package org.servletchaining.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/PasswordVerification")

public class PasswordVerification extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//fetch data
		String Password=req.getParameter("pwd");
		//jdbc code
		String url="jdbc:mysql://localhost:3306?user=root&password=1234";
		String query="select* from advancejava.accountdetails where Password=?";
	/*	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection(url);
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, Password);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
			{
				//show flipkart 
				resp.sendRedirect("https://www.flipcart.com");
			}
			else
			{
				RequestDispatcher dispatcher=req.getRequestDispatcher("Email.html");
				dispatcher.include(req, resp);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		} */
		
		//fetch data
		String password=req.getParameter("pwd");
		
		//access session object
		HttpSession session=req.getSession();
		
		//fetch data from session object
		String dbPassword =(String)session.getAttribute("pwd"); //Downcasting
		System.out.println("Password present in a session  " + dbPassword);
		
		
		if(dbPassword==null)
		{
			PrintWriter writer=resp.getWriter();
			writer.println("Session time is out.....");
		}
		else if(password.equals(dbPassword))
		{
			resp.sendRedirect("http://www.flipkart.com");
		}
		else
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("Email.html");
			dispatcher.include(req, resp);
		}
	}

}
