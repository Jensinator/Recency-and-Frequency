package com.hszg.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hszg.dto.ObservationTimes;
import com.hszg.dto.ObservationTimes.ObservationTime;
import com.hszg.dto.SingleObservationTime;
import com.kianaanalytics.computeNode.dataaccess.PersonVisibleAccessService;
import com.kianaanalytics.computeNode.model.PersonVisibleResult;

@Path("/util")
public class Util {

	@GET
	@Path("/observationTimes")
	@Produces(MediaType.APPLICATION_JSON)
	public static List<ObservationTimes> getObservationTimes(){
		
		List<ObservationTimes> times = new ArrayList<ObservationTimes>();
		
		PersonVisibleAccessService observationService = new PersonVisibleAccessService();
		PersonVisibleResult observations = observationService.computePersonVisible();
		
		for( int i = 0; i < observations.keySet().size(); i++ ){
			
			String clientMac = observations.keySet().toArray()[i].toString();
			
			ObservationTimes observationTimes = new ObservationTimes();
			observationTimes.setClientMac(clientMac);
			
			for( int j = 0; j < observations.get(clientMac).size(); j++ ){
				
				Date startTime = observations.get(clientMac).get(j).firstEntry().getValue().getStartObservationTimeUtc();
				Date endTime   = observations.get(clientMac).get(j).firstEntry().getValue().getEndObservationTimeUtc();
				
				SingleObservationTime start = new SingleObservationTime(startTime);
				SingleObservationTime end   = new SingleObservationTime(endTime);
				
				ObservationTimes.ObservationTime entry = new ObservationTime();
				entry.setStart(start);
				entry.setEnd(end);
				
				observationTimes.add(entry);	
			}
			
			times.add(observationTimes);
		}
		
		
		return times;
	}
	
	
}
