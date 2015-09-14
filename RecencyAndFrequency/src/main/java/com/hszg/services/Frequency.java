package com.hszg.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Frequency")
public class Frequency  {

	@GET
	@Path("/HelloWorld")
	@Produces(MediaType.TEXT_XML)
	public String sayHello(){
		// http://localhost:8080/RecencyAndFrequency/Frequency/HelloWorld/
		return "<hello>hello</hello>";
	}
	
}
