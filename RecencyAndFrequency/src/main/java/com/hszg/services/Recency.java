package com.hszg.services;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Recency")
public class Recency {

	@GET
	@Path("/HelloWorld")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello(){
		// http://localhost:8080/RecencyAndFrequency/Frequency/HelloWorld/
		return new String("Hallo");
	}
	
	@GET
	@Path("/RecencyDistribution")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Point> getRecencyDistribution(){
		
		List<Point> distribution = new ArrayList<Point>();
		
		distribution.add(new Point(2,5));
		
		return distribution;
	}
	
}
