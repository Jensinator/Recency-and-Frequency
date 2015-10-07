package com.hszg.dto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class RecencyDistributionTest {

	@Test(expected=IllegalArgumentException.class)
	public void testAddRecencyValueNegative() {
		
		Distribution distribution = new Distribution();
		
		int recency = -2;
		
		distribution.addValue(recency);
	}
	
	@Test
	public void testAddRecencyValuePositive() {
		
		List<Distribution.Point> expectedResult = new ArrayList<Distribution.Point>();
		
		expectedResult.add( new Distribution.Point(2,1) );
		
		Distribution distribution = new Distribution();
		
		int recency = 2;
		
		distribution.addValue(recency);
		
		Assert.assertEquals(expectedResult, distribution.getDistribution());
	}
	
	@Test
	public void testAddRecencyValueZero() {
		
		List<Distribution.Point> expectedResult = new ArrayList<Distribution.Point>();
		
		expectedResult.add( new Distribution.Point(0,1) );
		
		Distribution distribution = new Distribution();
		
		int recency = 0;
		
		distribution.addValue(recency);
		
		Assert.assertEquals(expectedResult, distribution.getDistribution());
	}
	
	@Test
	public void testAddRecencyValueDifferentValues() {
		
		List<Distribution.Point> expectedResult = new ArrayList<Distribution.Point>();
		
		expectedResult.add( new Distribution.Point(2,1) );
		
		expectedResult.add( new Distribution.Point(4,1) );
		
		expectedResult.add( new Distribution.Point(6,1) );
		
		expectedResult.add( new Distribution.Point(7,1) );
		
		expectedResult.add( new Distribution.Point(11,1) );
		
		Distribution distribution = new Distribution();
		

		
		distribution.addValue(4);
		
		distribution.addValue(6);
		
		distribution.addValue(2);
		
		distribution.addValue(11);
		
		distribution.addValue(7);
		
		Assert.assertEquals(expectedResult, distribution.getDistribution());
	}
	
	@Test
	public void testAddRecencyValueSameValues() {
		
		List<Distribution.Point> expectedResult = new ArrayList<Distribution.Point>();
		
		expectedResult.add( new Distribution.Point(2,2) );
		
		
		Distribution distribution = new Distribution();
		
		int recency = 2;
		
		distribution.addValue(recency);
		
		recency = 2;
		
		distribution.addValue(recency);
		
		Assert.assertEquals(expectedResult, distribution.getDistribution());
		
	}
	
	@Test
	public void testAddToFrequency(){
		
		Distribution distribution = new Distribution();
		distribution.addValue(2);
		distribution.addValue(4);
		distribution.addValue(3);
		distribution.addValue(3);
		
		Distribution distributionToAppend = new Distribution();
		distributionToAppend.addValue(1);
		distributionToAppend.addValue(2);
		
		Distribution frequencyDistribution = Distribution.addToFrequency(distribution, distributionToAppend);
		
		List<Distribution.Point> expectedResult = new ArrayList<Distribution.Point>();
		expectedResult.add( new Distribution.Point(1, 1));
		expectedResult.add( new Distribution.Point(2, 2));
		expectedResult.add( new Distribution.Point(3, 1));
		expectedResult.add( new Distribution.Point(4, 1));
		
		Assert.assertEquals(frequencyDistribution.getDistribution(), expectedResult);
		
	}
	
	@Test
	public void testAddToRecency(){
		
		Distribution distribution = new Distribution();
		distribution.addValue(2);
		distribution.addValue(4);
		distribution.addValue(3);
		distribution.addValue(3);
		
		Distribution distributionToAppend = new Distribution();
		distributionToAppend.addValue(1);
		distributionToAppend.addValue(2);
		
		distribution.add(distributionToAppend);
		
		List<Distribution.Point> expectedResult = new ArrayList<Distribution.Point>();
		expectedResult.add( new Distribution.Point(1, 1));
		expectedResult.add( new Distribution.Point(2, 2));
		expectedResult.add( new Distribution.Point(3, 2));
		expectedResult.add( new Distribution.Point(4, 1));
		
		Assert.assertEquals(distribution.getDistribution(), expectedResult);

	}

}
