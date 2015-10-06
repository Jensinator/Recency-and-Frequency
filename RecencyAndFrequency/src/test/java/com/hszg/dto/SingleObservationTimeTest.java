package com.hszg.dto;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

public class SingleObservationTimeTest {

	@Test
	public void testDateConstructor() {
		
SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		
		String dateString = "2015-12-03 00:01:55";
		Date date = null;
		try{
			 date = ft.parse(dateString);
		}catch(Exception unexpected){
			fail("invalid date string");
		}
		
		assertNotNull(date);
		
		SingleObservationTime timeToTest = new SingleObservationTime(date);
		
		Assert.assertEquals("2015", timeToTest.getYear());
		Assert.assertEquals("12", timeToTest.getMonth());
		Assert.assertEquals("3", timeToTest.getDay());
		Assert.assertEquals("0", timeToTest.getHours());
		Assert.assertEquals("1", timeToTest.getMinutes());
		Assert.assertEquals("0", timeToTest.getMinutesPerTenth());
		
	}

	
	@Test
	public void testCreate()  {
		
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		
		String dateString = "2015-01-02 12:11:10";
		Date date = null;
		try{
			 date = ft.parse(dateString);
		}catch(Exception unexpected){
			fail("invalid date string");
		}
		
		assertNotNull(date);
		
		SingleObservationTime timeToTest = new SingleObservationTime();
		
		timeToTest.create(date);
		
		Assert.assertEquals("2015", timeToTest.getYear());
		Assert.assertEquals("1", timeToTest.getMonth());
		Assert.assertEquals("2", timeToTest.getDay());
		Assert.assertEquals("12", timeToTest.getHours());
		Assert.assertEquals("1", timeToTest.getMinutes());
		Assert.assertEquals("1", timeToTest.getMinutesPerTenth());
		
	}
	
}
