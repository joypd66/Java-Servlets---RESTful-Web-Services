package com.example.RESTview;

import com.example.RESTcontroller.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("")
public class RestView{
	@GET
	@Produces("text/plain")
	public Response getOptions(){
		String userHistory = "http://localhost:9999/project3/users/history/{userName}:{password}";
		String tickerLookup = "http://localhost:9999/project3/users/postLookup/{stockTicker}:{userName}:{password}";
		String userRegistration = "http://localhost:9999/project3/users/postRegister/{userName}:{password}";
		
		String message = "{ \"addresses\" : [ \n" +
					"{ \"userHistory\" : \"" + userHistory + "\" }, \n" +
					"{ \"tickerLookup\" : \"" + tickerLookup + "\" }, \n" +
					"{ \"userRegistration\" : \"" + userRegistration + "\" } ] }";
		return Response.status(201).entity(message).build();
	}//end getOptions method	
}//end RestView class
