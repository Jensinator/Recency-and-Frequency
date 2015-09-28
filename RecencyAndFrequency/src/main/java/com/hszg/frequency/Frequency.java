package com.hszg.frequency;

import com.hszg.dto.RecencyDistribution;
import com.hszg.recency.Recency;
import com.kianaanalytics.computeNode.model.ObservationsOfClientMac;
import com.kianaanalytics.computeNode.model.PersonVisibleResult;

public class Frequency {

	public static RecencyDistribution compute( PersonVisibleResult observations ){
		
		RecencyDistribution distribution = new RecencyDistribution();
		
		for( int i = 0; i < observations.keySet().size(); i++ ){
			
			String clientMac = observations.keySet().toArray()[i].toString();
			
			ObservationsOfClientMac clientObservations = observations.get(clientMac);
				
			RecencyDistribution clientDistribution;
			try{
				clientDistribution = Recency.compute(clientMac, observations);
			}catch(Exception unexpected){
				clientDistribution = new RecencyDistribution();
			}
			
			distribution.addToFrequency(clientDistribution);
			
		}
		
		
		return distribution;
	}
	
	
}
