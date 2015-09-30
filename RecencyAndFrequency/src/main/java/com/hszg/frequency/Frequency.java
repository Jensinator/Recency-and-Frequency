package com.hszg.frequency;

import com.hszg.dto.RecencyDistribution;
import com.hszg.recency.Recency;
import com.kianaanalytics.computeNode.model.ObservationsOfClientMac;
import com.kianaanalytics.computeNode.model.PersonVisibleResult;

public class Frequency {

	/** This function computes the frequency distribution for all client
	 * 	macs.
	 *  @param observations - observations for each client mac address.
	 *  @return The distribution for frequency.
	 * */
	public static RecencyDistribution compute( PersonVisibleResult observations ){
		
		RecencyDistribution distribution = new RecencyDistribution();
		
		for( int i = 0; i < observations.keySet().size(); i++ ){
			
			String clientMac = observations.keySet().toArray()[i].toString();
				
			RecencyDistribution clientDistribution;
			try{
				clientDistribution = Recency.compute(clientMac, observations);
			}catch(Exception unexpected){
				clientDistribution = new RecencyDistribution();
			}
			
			RecencyDistribution frequency = RecencyDistribution.addToFrequency(distribution, clientDistribution);
			
			distribution.add(frequency);
			
		}
		
		return distribution;
	}
	
	
}
