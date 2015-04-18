package com.example.RESTcontroller;

import com.example.model.*;

public class LookupController{ 
	public String addLookup(String userName, String stockTicker){
		String message = null;

		//if the username has a value
		if(userName != ""){
			Lookup lookup = new Lookup();
			Stock stock = StockController.getInstance().getStockPrice(stockTicker);
			
			if(stock.getPrice() == 0.00){
				message = "{ \"status\" : \"error\", \n" +
					"\"message\" : \"Stock ticker " + stockTicker + " does not exist.\" }";
			}//end if statement

			else{
				lookup.addStock(userName, stock);
				
				message = "{ \"stockTicker\" : \"" + stock.getTicker() + "\",\n" +
						"\"stockPrice\" : " + stock.getPrice() + " }";				
			}//end else statement								
		}//end if statement

		else{
			message = "{ \"status\" : \"error\", \n" +
					"\"message\" : \"Username is an empty string.\" }";
		}//end else statement
		
		return message;
	}//end addLookup
}//end lookupController class
