package com.example.model;

import java.sql.*;

public class Lookup{
	public static boolean addStock(String userName, Stock stock){
		try{
			String stockTicker = stock.getTicker();
			float stockPrice = stock.getPrice();
			
			//loading driver 
			Class.forName("com.mysql.jdbc.Driver");

			//creating connection with the database
			Connection conn=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project3","root","password");

			PreparedStatement ps=conn.prepareStatement
				("insert into lookups (userName, stockTicker, stockPrice) values(?,?,?)");

			ps.setString(1, userName);
			ps.setString(2, stockTicker);
			ps.setFloat(3, stockPrice);
			
			int i = ps.executeUpdate();
			
			if(i>0){
				ps.close();
				conn.close();
				return true;
			}//end if statement	
			
			ps.close();
			conn.close();	
		}//end try block
		catch(Exception e){
			e.printStackTrace();
	      	}//end catch block

		return false;
	}//end addStock class
		
	public static History[] getHistory(String userName){
		String sqlCount = "select count(*) from lookups where userName= \"" + userName + "\"";
		int count = getCount(sqlCount);
		History[] historyArray = new History[count];
	
		try{
			//loading driver 
			Class.forName("com.mysql.jdbc.Driver");

			//creating connection with the database
			Connection conn=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project3","root","password");
			String sql = "select * from lookups where userName= \"" + userName + "\" order by id DESC";
			Statement st=conn.createStatement();

			ResultSet rs = st.executeQuery(sql);
			History history = null;
			int i = 0;
			while(rs.next()){
				history = new History();
				String timeStamp = rs.getString("timeStamp");
				String stockTicker = rs.getString("stockTicker");
				float stockPrice = rs.getFloat("stockPrice");
				history.setSearchNum(count - i);
				history.setTimeStamp(timeStamp);
				history.setStockTicker(stockTicker);
				history.setStockPrice(stockPrice);
				historyArray[i] = history;				
				i++;
			}//end while loop
		}//end try block
		catch(Exception e){
			e.printStackTrace();
	      	}//end catch block		
		
		return historyArray;
	}//end getHistory method
	
	public static int getCount(String sql){
		int count = -1;
		try{
			//loading driver 
			Class.forName("com.mysql.jdbc.Driver");

			//creating connection with the database
			Connection conn=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project3","root","password");
			Statement st=conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			rs.next();
			count = rs.getInt(1);
		}//end try block
		catch(Exception e){
			e.printStackTrace();
	      	}//end catch block	
		return count;
	}//end getCount method
}//end Lookup class
