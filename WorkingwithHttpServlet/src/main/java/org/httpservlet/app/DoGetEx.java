package org.httpservlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DoGetEx")

public class DoGetEx extends HttpServlet{
	protected void doGet(HttpServletRequest req ,HttpServletResponse resp) throws ServletException ,IOException{
		String username=req.getParameter("en");
		
		Date date=new Date();
		
		PrintWriter writer=resp.getWriter();
		writer.println("user Name :"+ username);
		writer.println("date :"+date);
		
		
	}

}
