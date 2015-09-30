package com.hszg.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hszg.dto.RecencyDistribution;
import com.kianaanalytics.computeNode.dataaccess.PersonVisibleAccessService;
import com.kianaanalytics.computeNode.model.PersonVisibleResult;

@Path("/Frequency")
public class Frequency  {

	
	@GET
	@Path("/FrequencyDistribution")
	@Produces(MediaType.APPLICATION_JSON)
	public RecencyDistribution getFrequencyDistribution(){
			
		PersonVisibleAccessService observationService = new PersonVisibleAccessService();
		PersonVisibleResult observations = observationService.computePersonVisible();
		
		RecencyDistribution distribution = new RecencyDistribution();
		
		try{
			distribution = com.hszg.frequency.Frequency.compute(observations);
		}catch( Exception unexpected){
			System.out.println(unexpected.toString());
		}
		
		return distribution;
		
	}
	
	
}
