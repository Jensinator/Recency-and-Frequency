package com.hszg.services;

import com.hszg.dto.Point;
import com.hszg.dto.RecencyDistribution;
import com.kianaanalytics.computeNode.dataaccess.PersonVisibleAccessService;
import com.kianaanalytics.computeNode.model.ObservationOfClientMac;
import com.kianaanalytics.computeNode.model.ObservationsOfClientMac;
import com.kianaanalytics.computeNode.model.PersonVisibleResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Recency")
public class Recency {

	
	@GET
	@Path("/RecencyDistribution")
	@Produces(MediaType.APPLICATION_JSON)
	public RecencyDistribution getRecencyDistribution(){
	  
		PersonVisibleAccessService observationService = new PersonVisibleAccessService();
	  
		PersonVisibleResult observations = observationService.computePersonVisible();
		RecencyDistribution distribution = new RecencyDistribution();
		
		for( int i = 0; i < observations.keySet().size();i++ ){
			
			String clientMac = (String) observations.keySet().toArray()[i];
			
			System.out.println("Client Mac " + clientMac);
			
			try {
				RecencyDistribution clientRecencyDistribution = com.hszg.recency.Recency.compute(clientMac,observations);
				distribution.add(clientRecencyDistribution);
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		}
		
		
	  
		return distribution;
	 }
	 
	
	@GET
	@Path("/RecencyDistributionForClientMac")
	@Produces(MediaType.APPLICATION_JSON)
	public RecencyDistribution getRecencyDistribution(@QueryParam("clientMac") String clientMac) {

		PersonVisibleAccessService observationService = new PersonVisibleAccessService();

		PersonVisibleResult observations = observationService.computePersonVisible();
		RecencyDistribution distribution = null;
		try {
			ObservationsOfClientMac macObservation = observations.get(clientMac);
			if( macObservation == null ){
				throw new Exception("There is no entry for client mac : " + clientMac);
			}
			
			distribution = com.hszg.recency.Recency.compute(macObservation.toString(), observations);
		} catch (Exception e) {
			e.printStackTrace();
			distribution = new RecencyDistribution();
		}

		return distribution;
	}
	
	
	
}
