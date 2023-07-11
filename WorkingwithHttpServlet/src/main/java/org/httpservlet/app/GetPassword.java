package org.httpservlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/GetPassword")
public class GetPassword extends HttpServlet{
	
	 protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException 
	 {
		 String email=req.getParameter("em");
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?","root","1234");
			PreparedStatement ps=cn.prepareStatement("select * from advancejava.accountdetails where Email=?");
			ps.setString(1, email);
		    ResultSet rs=ps.executeQuery();
		    PrintWriter writer=resp.getWriter();
		    if(rs.next())
		    {
		    	//retrive the password
		    	String password=rs.getString("Password");
		    	writer.println("your password is :"+ password);
		    }
		    else
		    {
		    	writer.print("please enter the valid email");
		    }
		    cn.close();
		    
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		 
		 
	 }
		

}
