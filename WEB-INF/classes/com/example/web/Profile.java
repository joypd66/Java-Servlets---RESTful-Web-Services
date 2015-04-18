package com.example.web;

import java.io.IOException;  
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Cookie; 

/*This is a controller class, it interacts with the view*/

public class Profile extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		response.setContentType("text/html");
		RequestDispatcher view;

		//Cookie ck[]=request.getCookies();
		//if(ck!=null){

		HttpSession session = null;
		session = request.getSession(false);

		if(session != null){  
		//String userName=ck[0].getValue();
  		
		String userName = (String)session.getAttribute("userName");
		//if the username has a value
			if(userName != ""){
				String profileMessage = userName + "'s profile";
				request.setAttribute("profileMessage", profileMessage);
				view = request.getRequestDispatcher("profile.jsp");
				view.forward(request, response);
			}//end if statement
			else{  
				String failMessage = "Please login or register to begin.";
				request.setAttribute("failMessage", failMessage);
				view = request.getRequestDispatcher("profile.jsp");
				view.forward(request, response);
			}//end else statement 
		}//end if statement

		//otherwise user is not logged in, send them to login page.
		else{  
			String failMessage = "Please login or register to begin.";
			request.setAttribute("failMessage", failMessage);
			view = request.getRequestDispatcher("profile.jsp");
			view.forward(request, response);
		}//end else statement 
	}//end do get
}//end profile class
