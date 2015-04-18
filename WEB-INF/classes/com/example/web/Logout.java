package com.example.web;
  
import java.io.IOException;    
import javax.servlet.ServletException;    
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*; 
import javax.servlet.http.*;
//import javax.servlet.http.Cookie;   

/*This is a controller class it should send a message to the view.*/

public class Logout extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                        throws ServletException, IOException {  
		response.setContentType("text/html");
		RequestDispatcher view;
		String message = "You have successfully logged out.";        
		  
		//Cookie ck=new Cookie("userName","");  
		//ck.setMaxAge(0);  
		//response.addCookie(ck);

		HttpSession session = request.getSession(false); 
		if(session != null){ 
        		session.setAttribute("userName", "");  
		}//end if statement

		request.setAttribute("logout",message);
		view = request.getRequestDispatcher("logout.jsp");
		view.forward(request, response);  
	}//end do get method
}//end logout class
