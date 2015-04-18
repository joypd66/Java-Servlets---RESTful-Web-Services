package com.example.model;

import java.sql.*;

public class History{
	private int searchNum;
	private String timeStamp;
	private String stockTicker;
	private float stockPrice;

	public History(){}
		
	public void setSearchNum(int searchNum){
		this.searchNum = searchNum;
	}//end setSearchNum

	public void setTimeStamp(String timeStamp){
		this.timeStamp = timeStamp;
	}//end setTimeStamps method
	
	public void setStockTicker(String stockTicker){
		this.stockTicker = stockTicker;
	}//end setStockTickers method
		
	public void setStockPrice(float stockPrice){
		this.stockPrice = stockPrice;
	}//end setStockPrices method

	public int getSearchNum(){
		return searchNum;
	}//end setSearchNum
		
	public String getTimeStamp(){
		return timeStamp;
	}//end getTimeStamps method
	
	public String getStockTicker(){
		return stockTicker;
	}//end getStockTickers method
	
	public float getStockPrice(){
		return stockPrice;
	}//end getStockPrices method	
}//end History class
