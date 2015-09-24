package com.hszg.recency;



import com.hszg.dto.RecencyDistribution;
import com.kianaanalytics.computeNode.model.ObservationOfClientMac;
import com.kianaanalytics.computeNode.model.ObservationsOfClientMac;
import com.kianaanalytics.computeNode.model.PersonVisibleResult;
import com.kianaanalytics.computeNode.util.BigQueryDate;

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
		
		for( int i = 0; i < observationsForClientMac.size(); i++ ){
			
			ObservationOfClientMac observation = observationsForClientMac.get(i);
			
			// elemental case
			if(observation.keySet().size() < 2 ){
				distribution.addRecencyValue(RecencyDistribution.NO_RECENCY);
			}

			
			
			// else case
			for( int j = 0; j < observation.keySet().size() - 1; j++ ){
				
				long keyEndTime   = (long)observation.keySet().toArray()[j];
				long keyStartTime = (long)observation.keySet().toArray()[j+1];
				
				//Time
				BigQueryDate endTime = observation.get(keyEndTime).getEndObservationTimeUtc();
				BigQueryDate startTime = observation.get(keyStartTime).getStartObservationTimeUtc();	
				
				System.out.println("end t : " + endTime );
				System.out.println("start t : " + startTime);
				
				int recency = DateCalculator.getDiffInDays(endTime, startTime);
				
				distribution.addRecencyValue(recency);
			}

		}
		
		return distribution;
	}
	
	
}
