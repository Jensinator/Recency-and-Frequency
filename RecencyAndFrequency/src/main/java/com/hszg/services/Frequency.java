package com.hszg.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Frequency")
public class Frequency  {

	@GET
	@Path("/HelloWorld")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> sayHello(){
		// http://localhost:8080/RecencyAndFrequency/Frequency/HelloWorld/
		return new ArrayList<String>();
	}
	
	
	
	
	
}
