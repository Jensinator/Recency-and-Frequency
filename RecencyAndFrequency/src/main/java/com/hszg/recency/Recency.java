package com.hszg.recency;

import com.hszg.dto.RecencyDistribution;
import com.kianaanalytics.computeNode.model.ObservationOfClientMac;
import com.kianaanalytics.computeNode.model.ObservationsOfClientMac;
import com.kianaanalytics.computeNode.model.PartialObservation;
import com.kianaanalytics.computeNode.model.PersonVisibleResult;
import com.kianaanalytics.computeNode.util.BigQueryDate;

/** This class contains functions to compute a Recency Distribution
 *	based on a client mac address.
 */
public class Recency {
	
	
	/** This function computes the recency for a specific client mac.
	 *	@param clientMac - The client mac the recency should be computed for.
	 *	@param observations - The Container which contains all observations mapped to client macs.
	 *	@return Recency for the client mac.
	 *  @throws Exception 
	 */
	public static RecencyDistribution compute( String clientMac, PersonVisibleResult observations ) throws Exception{
		
		ObservationsOfClientMac observationsForClientMac = observations.get(clientMac);
		if( observationsForClientMac == null ){
			throw new Exception("There are no observations for client mac : " + clientMac );
		}
		
		RecencyDistribution distribution = new RecencyDistribution();
		
		// elementary event
		if(observationsForClientMac.size() < 2 ){
			distribution.addRecencyValue(RecencyDistribution.NO_RECENCY);
		}
		
		// normal event
		for( int i = 0; i < observationsForClientMac.size() - 1; i++ ){
			
			ObservationOfClientMac observation1 = observationsForClientMac.get(i);
			ObservationOfClientMac observation2 = observationsForClientMac.get(i+1);
			
			int recency = computeRecency(observation1, observation2);
			
			distribution.addRecencyValue(recency);
			
		}
		
		return distribution;
	}
	
	
	/** This function computes the difference in days between the end time of the first and the start time of
	 *  the second observation.
	 *  @param observation1 - first observation in time to take end time from.
	 *  @param observation2 - second observation in time to take start time from.
	 *  @return The recency.
	 **/
	private static int computeRecency( ObservationOfClientMac observation1, ObservationOfClientMac observation2 ){
		
		PartialObservation partObservation1 = observation1.firstEntry().getValue();
		PartialObservation partObservation2 = observation2.firstEntry().getValue();
		
		BigQueryDate endTime   = partObservation1.getEndObservationTimeUtc();
		BigQueryDate startTime = partObservation2.getStartObservationTimeUtc();	
		
		int recency = DateCalculator.getDiffInDays(endTime, startTime);
		
		return recency;
	}
	
}
