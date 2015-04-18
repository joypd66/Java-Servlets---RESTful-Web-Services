package com.example.model;

import java.sql.*;

public class User{
	public static boolean addUser(String userName, String password){
		try{
			//loading driver 
			Class.forName("com.mysql.jdbc.Driver");

			//creating connection with the database 
			Connection conn=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project3","root","password");

			PreparedStatement ps=conn.prepareStatement
				("insert into users values(?,?)");

			ps.setString(1, userName);
			ps.setString(2, password);
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
	}//end addUser class

	public static boolean checkUsername(String userName) {
		boolean result =false;

		try{
		//loading driver 
		Class.forName("com.mysql.jdbc.Driver");

		//creating connection with the database 
		Connection conn=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/project3","root","password");
		PreparedStatement ps = conn.prepareStatement("select * from users where userName=?");
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		result = rs.next();
		
		rs.close();
		ps.close();
		conn.close();
		}//end try block

		catch(Exception e){
			e.printStackTrace();
		}//end catch block

		return result;     
	}//end checkUser method
	
	public static boolean checkLogin(String userName,String password) {
	      boolean result =false;
	      try{
		 //loading driver 
		 Class.forName("com.mysql.jdbc.Driver");

	 	 //creating connection with the database 
		 Connection conn=DriverManager.getConnection
		                ("jdbc:mysql://localhost:3306/project3","root","password");
		 PreparedStatement ps = conn.prepareStatement
		                     ("select * from users where userName=? and password=?");
		 ps.setString(1, userName);
		 ps.setString(2, password);
		 ResultSet rs = ps.executeQuery();
		 result = rs.next();
		
		 rs.close();
		 ps.close();
		 conn.close();
	      }//end try block
	      catch(Exception e){
		  e.printStackTrace();
	      }//end catch block
	      return result;     
     }//end checkUser method
}//end ValidateLogin class
