package com.example.web;

import com.example.model.*;
import java.io.IOException;    
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*; 
import javax.servlet.http.*; 

/*This is a controller class, it communicates with the model and the view*/
public class Register extends HttpServlet { 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter(); 
		RequestDispatcher view;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");

		username = username.trim();
		password = password.trim();
		confirm = confirm.trim();

		//check inputs
		Boolean fail = false;
		//check username input
		String uValue = null;
		String uLength = null;
		if(username.equals("") || username == null){
			uValue = "Username was not entered.";
			fail = true;
		}//end if statement

		else{
			//check username length
			if(username.length() > 20 || username.length() < 5){
				uLength = "Username must be between 5 and 20 characters in length.";
				fail = true;
			}//end if statement
		}//end else statement

		//check password input
		String pValue = null;
		String pLength = null;
		if(password.equals("") || password == null){
			pValue = "Password was not entered.";
			fail = true;
		}//end if statement

		else{
			//check username length
			if(password.length() > 20 || password.length() < 5){
			pLength = "Password must be between 5 and 20 characters in length.";
			fail = true;
			}//end if statement
			}//end else statement

			//check equality
			String equals = null;
		if(!password.equals(confirm)){
			equals = "The passwords do not match. Try again.";
			fail = true;
		}//end if statement

		//if fail send all the messages
		if(fail){
			request.setAttribute("uValue", uValue);
			request.setAttribute("uLength", uLength); 
			request.setAttribute("pValue", pValue); 
			request.setAttribute("pLength", pLength); 
			request.setAttribute("equals", equals);    
			view = request.getRequestDispatcher("loginRegister.jsp");	     
			view.forward(request, response);
		}//end if statement

		else{
			//create a a new User object to validate the username
			//Validate login is a model class
			User validate = new User();
			User register = new User();

			boolean userexists = validate.checkUsername(username);

			//if username already exists
			String uExists = null;
			if(userexists){
				uExists = "This username is taken. Please try another.";
				request.setAttribute("uExists", uExists);
				view = request.getRequestDispatcher("loginRegister.jsp"); 	
				view.forward(request, response);
			}//end if statement

			//if username does not exist.
			else{
				boolean result = register.addUser(username, password);

				//if registration is successfull
				String registerMessage = null;
				String failed = null;
				if(result){
					registerMessage = "You've successfully registered!";
					request.setAttribute("registerMessage", registerMessage); 
					Cookie ck=new Cookie("username",username);
					response.addCookie(ck);	    
					view = request.getRequestDispatcher("welcome.jsp");	     
					view.forward(request, response);
				}//end if statement

				//else registration failed
				else{
					failed = "Registration Failed.";
					request.setAttribute("failed", failed);   
					view = request.getRequestDispatcher("loginRegister.jsp");	     
					view.forward(request, response);
				}//end else statement
			}//end else statement
		}//end else statement
	}//end do post
}//end register class
