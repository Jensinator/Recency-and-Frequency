package com.hszg.frequency;

import com.hszg.dto.Distribution;
import com.hszg.recency.Recency;
import com.kianaanalytics.computeNode.model.ObservationsOfClientMac;
import com.kianaanalytics.computeNode.model.PersonVisibleResult;

public class Frequency {

	/** This function computes the frequency distribution for all client
	 * 	macs.
	 *  @param observations - observations for each client mac address.
	 *  @return The distribution for frequency.
	 * */
	public static Distribution compute( PersonVisibleResult observations ){
		
		Distribution distribution = new Distribution();
		
		for( int i = 0; i < observations.keySet().size(); i++ ){
			
			String clientMac = observations.keySet().toArray()[i].toString();
				
			Distribution clientDistribution;
			try{
				clientDistribution = Recency.compute(clientMac, observations);
			}catch(Exception unexpected){
				clientDistribution = new Distribution();
			}
			
			Distribution frequency = Distribution.addToFrequency(distribution, clientDistribution);
			
			distribution.add(frequency);
			
		}
		
		return distribution;
	}
	
	
}
