package com.hszg.recency;

import java.util.Date;

public class DateCalculator {

	/** This function rounds a date in relation to its day to time 00:00:00 
	 *  of that day.
	 *  @param timestamp - The timestamp to normalize.
	 *  @return Normalized timestamp.
	 * */
	public static Date roundToFullDay(Date timestamp){
		
		Date date = new Date();
		
		date.setTime(timestamp.getTime());
		
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		
		return date;
	}
	
	/** This function computes the number of days between two dates.
	 *  @return number of days (round off)
	 * */
	public static int getDiffInDays( Date startTime, Date endTime ){
		
		long startTimeInMs = startTime.getTime();
		long endTimeInMs   = endTime.getTime();
		
		long diffInMs = endTimeInMs - startTimeInMs;
		
		long diffInDays = diffInMs/(1000 * 60 * 60 * 24);
		
		if(diffInDays < 0){
			
			throw new IllegalArgumentException("Endtime has to be greater than starttime.");
		}
	
		return (int)diffInDays;
	}
	
	
}
