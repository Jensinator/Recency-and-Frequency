package com.hszg.dto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class RecencyDistributionTest {

	@Test(expected=IllegalArgumentException.class)
	public void testAddRecencyValueNegative() {
		
		RecencyDistribution distribution = new RecencyDistribution();
		
		int recency = -2;
		
		distribution.addRecencyValue(recency);
	}
	
	@Test
	public void testAddRecencyValuePositive() {
		
		List<RecencyDistribution.Point> expectedResult = new ArrayList<RecencyDistribution.Point>();
		
		expectedResult.add( new RecencyDistribution.Point(2,1) );
		
		RecencyDistribution distribution = new RecencyDistribution();
		
		int recency = 2;
		
		distribution.addRecencyValue(recency);
		
		Assert.assertEquals(expectedResult, distribution.getDistribution());
	}
	
	@Test
	public void testAddRecencyValueZero() {
		
		List<RecencyDistribution.Point> expectedResult = new ArrayList<RecencyDistribution.Point>();
		
		expectedResult.add( new RecencyDistribution.Point(0,1) );
		
		RecencyDistribution distribution = new RecencyDistribution();
		
		int recency = 0;
		
		distribution.addRecencyValue(recency);
		
		Assert.assertEquals(expectedResult, distribution.getDistribution());
	}
	
	@Test
	public void testAddRecencyValueDifferentValues() {
		
		List<RecencyDistribution.Point> expectedResult = new ArrayList<RecencyDistribution.Point>();
		
		expectedResult.add( new RecencyDistribution.Point(2,1) );
		
		expectedResult.add( new RecencyDistribution.Point(4,1) );
		
		expectedResult.add( new RecencyDistribution.Point(6,1) );
		
		expectedResult.add( new RecencyDistribution.Point(7,1) );
		
		expectedResult.add( new RecencyDistribution.Point(11,1) );
		
		RecencyDistribution distribution = new RecencyDistribution();
		

		
		distribution.addRecencyValue(4);
		
		distribution.addRecencyValue(6);
		
		distribution.addRecencyValue(2);
		
		distribution.addRecencyValue(11);
		
		distribution.addRecencyValue(7);
		
		Assert.assertEquals(expectedResult, distribution.getDistribution());
	}
	
	@Test
	public void testAddRecencyValueSameValues() {
		
		List<RecencyDistribution.Point> expectedResult = new ArrayList<RecencyDistribution.Point>();
		
		expectedResult.add( new RecencyDistribution.Point(2,2) );
		
		
		RecencyDistribution distribution = new RecencyDistribution();
		
		int recency = 2;
		
		distribution.addRecencyValue(recency);
		
		recency = 2;
		
		distribution.addRecencyValue(recency);
		
		Assert.assertEquals(expectedResult, distribution.getDistribution());
		
	}
	
	@Test
	public void testAddToFrequency(){
		
		RecencyDistribution distribution = new RecencyDistribution();
		distribution.addRecencyValue(2);
		distribution.addRecencyValue(4);
		distribution.addRecencyValue(3);
		distribution.addRecencyValue(3);
		
		RecencyDistribution distributionToAppend = new RecencyDistribution();
		distributionToAppend.addRecencyValue(1);
		distributionToAppend.addRecencyValue(2);
		
		RecencyDistribution frequencyDistribution = RecencyDistribution.addToFrequency(distribution, distributionToAppend);
		
		List<RecencyDistribution.Point> expectedResult = new ArrayList<RecencyDistribution.Point>();
		expectedResult.add( new RecencyDistribution.Point(1, 1));
		expectedResult.add( new RecencyDistribution.Point(2, 2));
		expectedResult.add( new RecencyDistribution.Point(3, 1));
		expectedResult.add( new RecencyDistribution.Point(4, 1));
		
		Assert.assertEquals(frequencyDistribution.getDistribution(), expectedResult);
		
	}
	
	@Test
	public void testAddToRecency(){
		
		RecencyDistribution distribution = new RecencyDistribution();
		distribution.addRecencyValue(2);
		distribution.addRecencyValue(4);
		distribution.addRecencyValue(3);
		distribution.addRecencyValue(3);
		
		RecencyDistribution distributionToAppend = new RecencyDistribution();
		distributionToAppend.addRecencyValue(1);
		distributionToAppend.addRecencyValue(2);
		
		distribution.add(distributionToAppend);
		
		List<RecencyDistribution.Point> expectedResult = new ArrayList<RecencyDistribution.Point>();
		expectedResult.add( new RecencyDistribution.Point(1, 1));
		expectedResult.add( new RecencyDistribution.Point(2, 2));
		expectedResult.add( new RecencyDistribution.Point(3, 2));
		expectedResult.add( new RecencyDistribution.Point(4, 1));
		
		Assert.assertEquals(distribution.getDistribution(), expectedResult);

	}

}
