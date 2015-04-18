package com.example.web;

import com.example.model.*;
import java.io.*;
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*; 
import javax.servlet.http.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import javax.servlet.http.Cookie;  

/*This is a controller class, it communicates with the model and the view*/

public class ShowHistory extends HttpServlet{ 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html");
		RequestDispatcher view;
		String historyMessage = null;

		HttpSession session = request.getSession(false);
		if(session != null){ 
			
			String userName = (String)session.getAttribute("userName");
			if(userName!=null){
				Lookup lookup = new Lookup();
				History[] historyArray = lookup.getHistory(userName);
				
				if(historyArray != null){	
					for(int i = 0; i < historyArray.length; i++){
						if(i == 0){
							historyMessage =  "Search Number: " + historyArray[i].getSearchNum() + "<br>" +
							"Time Stamp: " + historyArray[i].getTimeStamp() + "<br>" + 								"Stock Ticker: " + historyArray[i].getStockTicker() + "<br>" +
	 							"Stock Price: " + historyArray[i].getStockPrice();
						}//end if statement
						else{
							historyMessage = historyMessage + "<br><br>" + 
								"Search Number: " + historyArray[i].getSearchNum() + "<br>" +
								"Time Stamp: " + historyArray[i].getTimeStamp() + "<br>" + 									"Stock Ticker: " + historyArray[i].getStockTicker() + "<br>" +
	 							"Stock Price: " + historyArray[i].getStockPrice();
						}//end else statement
					}//end for loop			
									
					if(historyMessage != null){
						request.setAttribute("historyMessage", historyMessage);
					}//end if statement

					view = request.getRequestDispatcher("history.jsp");
					view.forward(request, response);
				}//end if statement
				else{
					String historyFailMessage = "Could not retrieve history.";
					request.setAttribute("historyFailMessage", historyFailMessage);
					view = request.getRequestDispatcher("profile.jsp");
					view.forward(request, response);
				}//end else statement							
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
	}//end do get method
}//end ShowHistory class
