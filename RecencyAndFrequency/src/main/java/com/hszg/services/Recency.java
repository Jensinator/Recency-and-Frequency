package com.hszg.services;

import com.hszg.dto.Point;
import com.kianaanalytics.computeNode.dataaccess.PersonVisibleAccessService;
import com.kianaanalytics.computeNode.model.PersonVisibleResult;

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
	public Point getRecencyDistribution(){
		
		PersonVisibleAccessService observationService = new PersonVisibleAccessService();
		
		//PersonVisibleResult Observations = observationService.computePersonVisible();
		
		//observationService.showResults( Observations.getResultCollection() );
		
		return new Point(1.0f,13.0f);
	}
	
}
