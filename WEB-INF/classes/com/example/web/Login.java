package com.example.web;

import com.example.model.*;
import java.io.IOException;    
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*; 
import javax.servlet.http.*;
//import javax.servlet.http.Cookie;

/*This is a controller class, it communicates with the model and the view*/

public class Login extends HttpServlet { 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

		response.setContentType("text/html");
		//PrintWriter out = response.getWriter(); 

		RequestDispatcher view;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//create a new validate login object
		//Validate login is a model class
		User validate = new User();
		boolean result = validate.checkLogin(userName, password);

		//if login is successful do this
		if(result){
			String loginMessage = "You've successfully logged in!";
			request.setAttribute("loginMessage", loginMessage);
 
			//Cookie ck=new Cookie("userName",userName);
			//response.addCookie(ck);

			HttpSession session=request.getSession();  
        		session.setAttribute("userName",userName);
			   
			view = request.getRequestDispatcher("welcome.jsp");	     
			view.forward(request, response);
		}//end if statement

		//if login fails do this.
		else{
			String validateMessage = "Username or Password incorrect, please login or register.";
			request.setAttribute("validateMessage", validateMessage);
			view = request.getRequestDispatcher("loginRegister.jsp"); 	
			view.forward(request, response);                  
		}//end else statement
	}//end do post
}//end validate class
