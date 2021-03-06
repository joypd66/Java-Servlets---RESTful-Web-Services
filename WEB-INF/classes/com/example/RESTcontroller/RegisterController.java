package com.example.RESTcontroller;

import com.example.model.*; 

/*This is a controller class, it communicates with the model and the view*/
public class RegisterController { 
	
	public RegisterController(){}

	public boolean addUser(String userName, String password){

		userName = userName.trim();
		password = password.trim();

		//check inputs
		Boolean fail = false;
		//check username input
		if(userName.equals("") || userName == null){			
			fail = true;
		}//end if statement

		else{
			//check userName length
			if(userName.length() > 20 || userName.length() < 5){
				fail = true;
			}//end if statement
		}//end else statement

		//check password input
		if(password.equals("") || password == null){
			fail = true;
		}//end if statement

		else{
			//check password length
			if(password.length() > 20 || password.length() < 5){
				fail = true;
			}//end if statement
		}//end else statement
		
		//if fail is true
		if(fail){
			return false;
		}//end if statement*/

		else{
			User register = new User();
			boolean result = register.addUser(userName, password);
			return result;
		}//end else statement
	}//end addUser method
}//end registercontroller class
