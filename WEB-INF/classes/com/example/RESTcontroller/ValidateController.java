package com.example.RESTcontroller;

import com.example.model.*;

public class ValidateController{ 
	public Boolean validateUser(String userName, String password){
		User validate = new User();
		boolean result = validate.checkLogin(userName, password);
		return result;
	}//end validateUser method
}//end ValidateController class
