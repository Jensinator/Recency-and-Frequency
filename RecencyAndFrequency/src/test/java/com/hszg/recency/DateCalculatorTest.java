package com.hszg.recency;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

public class DateCalculatorTest {

	@Test
	public void testRoundToFullDay() {
		
		
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		
		String expectedDateString = "2015-12-03 00:00:00";
		Date expectedDate = null;
		try{
			expectedDate = ft.parse(expectedDateString);
		}catch(Exception unexpected){
			fail("invalid date string");
		}
		
		String dateString = "2015-12-03 00:01:55";
		Date date = null;
		try{
			 date = ft.parse(dateString);
		}catch(Exception unexpected){
			fail("invalid date string");
		}
		
		DateCalculator dc = new DateCalculator();
		
		Date testDate = dc.roundToFullDay(date);
		
		Assert.assertEquals(expectedDate.getTime(), testDate.getTime());
	}
	
	
	@Test
	public void testGetDiffInDaysZero() {
		
		
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		
		String startDateString = "2015-12-03 00:00:00";
		Date startDate = null;
		try{
			startDate = ft.parse(startDateString);
		}catch(Exception unexpected){
			fail("invalid date string");
		}
		
		String endString = "2015-12-03 00:01:55";
		Date endDate = null;
		try{
			endDate = ft.parse(endString);
		}catch(Exception unexpected){
			fail("invalid date string");
		}
		
		int expectedDiff = 0;
		
		DateCalculator dc = new DateCalculator();
		
		int diff = dc.getDiffInDays(startDate, endDate);
		
		Assert.assertEquals(expectedDiff, diff);
	}
	
	@Test
	public void testGetDiffInDaysTwo() {
		
		
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		
		String startDateString = "2015-12-03 00:00:00";
		Date startDate = null;
		try{
			startDate = ft.parse(startDateString);
		}catch(Exception unexpected){
			fail("invalid date string");
		}
		
		String endString = "2015-12-05 00:01:55";
		Date endDate = null;
		try{
			endDate = ft.parse(endString);
		}catch(Exception unexpected){
			fail("invalid date string");
		}
		
		int expectedDiff = 2;
		
		DateCalculator dc = new DateCalculator();
		
		int diff = dc.getDiffInDays(startDate, endDate);
		
		Assert.assertEquals(expectedDiff, diff);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetDiffInDaysNegativ() {
		
		
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		
		String startDateString = "2015-12-05 00:00:00";
		Date startDate = null;
		try{
			startDate = ft.parse(startDateString);
		}catch(Exception unexpected){
			fail("invalid date string");
		}
		
		String endString = "2015-12-03 00:01:55";
		Date endDate = null;
		try{
			endDate = ft.parse(endString);
		}catch(Exception unexpected){
			fail("invalid date string");
		}
		
		DateCalculator dc = new DateCalculator();
		
		int diff = dc.getDiffInDays(startDate, endDate);
		
	}

}
