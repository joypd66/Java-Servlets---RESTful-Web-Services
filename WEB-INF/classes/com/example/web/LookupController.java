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

public class LookupController extends HttpServlet{ 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html");
		RequestDispatcher view;
		
		//Cookie ck[]=request.getCookies();
		//if(ck!=null){ 

		HttpSession session = request.getSession(false);		
		if(session != null){
			//String userName = ck[0].getValue();
			
			String userName = (String)session.getAttribute("userName");

			//if the username has a value
			if(userName != ""){
				Lookup lookup = new Lookup();
				String stockTicker = request.getParameter("stockTicker").toUpperCase().trim();
				Stock stock = StockController.getInstance().getStockPrice(stockTicker);
				
				if(stock.getPrice() == 0.00){
					String profileMessage = userName + "'s profile";
					String stockFailMessage = "The ticker symbol " + stockTicker + " does not exist.";
					request.setAttribute("profileMessage", profileMessage);
					request.setAttribute("stockFailMessage", stockFailMessage);
					view = request.getRequestDispatcher("profile.jsp");
					view.forward(request, response);
				}//end if statement

				else{
					lookup.addStock(userName, stock);				
					String profileMessage = userName + "'s profile";
					String stockTickerMessage = stock.getTicker();
					String stockPriceMessage = Float.toString(stock.getPrice());
					request.setAttribute("profileMessage", profileMessage);
					request.setAttribute("stockTickerMessage", stockTickerMessage);
					request.setAttribute("stockPriceMessage", stockPriceMessage);
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
	}//end do post
}//end lookup class
