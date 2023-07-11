package org.httpservlet.app;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DisplayDate")
public class DisplayDate extends HttpServlet {

	 protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException 
	
	 {
		//fetch data from html file
		 String userName=req.getParameter("user");
		 //display current system date
		 Date date=new Date();
		 //Display output onm browser
		 PrintWriter writer=resp.getWriter();
		 writer.println("User Name :" +userName);
		 writer.println("System Date :"+date);
	 }
}
