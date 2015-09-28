package com.hszg.recency;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hszg.dto.RecencyDistribution;
import com.hszg.dto.RecencyDistribution.Point;
import com.kianaanalytics.computeNode.model.PartialObservation;
import com.kianaanalytics.computeNode.model.PersonVisibleCondition;
import com.kianaanalytics.computeNode.model.PersonVisibleResult;

import junit.framework.Assert;

public class RecencyTest {

	private String clientMac;
	PersonVisibleResult personVisibleResult;
	
	@Before
	public void initialize(){
		clientMac = "00:61:71:5f:f4:3a";
		
		PersonVisibleCondition personVisibleCondition = new PersonVisibleCondition();

		personVisibleResult = new PersonVisibleResult(personVisibleCondition);
		
		PartialObservation partialObservation = new PartialObservation();
		
		partialObservation.setClientMac(clientMac);
		partialObservation.setApMac("");
		partialObservation.setAverageRssi(0.0f);
		partialObservation.setTimezoneOfStore("");
		
		Date startDate = new Date(2015, 1, 1, 1, 1, 1);
		Date endDate   = new Date(2015,1,2,1,1,1);
		
		partialObservation.setStartObservationTimeUtc(startDate.getTime());
		partialObservation.setEndObservationTimeUtc(endDate.getTime());
		
		personVisibleResult.addPartialObservation(partialObservation);
		
	}
	
	@Test
	public void test() {
		
		RecencyDistribution distribution;
		
		try{
			 distribution = Recency.compute(clientMac,personVisibleResult);
		}catch( Exception unexpected ){
			fail(unexpected.toString());
			return;
		}
		
		List<Point> expectedResult = new ArrayList<Point>();
		Point point = new RecencyDistribution.Point(RecencyDistribution.NO_RECENCY,1);
		expectedResult.add( point );
		
		Assert.assertEquals( expectedResult, distribution.getDistribution());

	}

}
