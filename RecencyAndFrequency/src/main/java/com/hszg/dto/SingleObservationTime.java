package com.hszg.dto;

import java.util.Date;

public class SingleObservationTime {

		private String minutes;
		private String minutesPerTenth;
		private String hours;
		private String day;
		private String month;
		private String year;
		
		public SingleObservationTime(){
			this.minutes = "";
			this.minutesPerTenth = "";
			this.hours = "";
			this.day = "";
			this.month = "";
			this.year = "";
		}
		
		public SingleObservationTime( Date date ){
			this.create(date);
		}
		
		public SingleObservationTime(String minutes, String minutesPerTenth, String hours, String day, String month, String year){
			this.minutes = minutes;
			this.minutesPerTenth = minutesPerTenth;
			this.hours = hours;
			this.day = day;
			this.month = month;
			this.year = year;
		}
			
		public void create(Date date){
			
			this.minutes = "" + (date.getMinutes() % 10);
			this.minutesPerTenth = "" + (date.getMinutes() / 10);
			this.hours = "" + date.getHours();
			this.day = "" + date.getDate();
			this.month = "" + (date.getMonth() + 1);
			this.year = "" + (date.getYear() +1900);
		}
		
		
		/**
		 * @return the minutes
		 */
		public String getMinutes() {
			return minutes;
		}


		/**
		 * @param minutes the minutes to set
		 */
		public void setMinutes(String minutes) {
			this.minutes = minutes;
		}


		/**
		 * @return the minutesPerTenth
		 */
		public String getMinutesPerTenth() {
			return minutesPerTenth;
		}


		/**
		 * @param minutesPerTenth the minutesPerTenth to set
		 */
		public void setMinutesPerTenth(String minutesPerTenth) {
			this.minutesPerTenth = minutesPerTenth;
		}


		/**
		 * @return the hours
		 */
		public String getHours() {
			return hours;
		}


		/**
		 * @param hours the hours to set
		 */
		public void setHours(String hours) {
			this.hours = hours;
		}


		/**
		 * @return the day
		 */
		public String getDay() {
			return day;
		}


		/**
		 * @param day the day to set
		 */
		public void setDay(String day) {
			this.day = day;
		}


		/**
		 * @return the month
		 */
		public String getMonth() {
			return month;
		}


		/**
		 * @param month the month to set
		 */
		public void setMonth(String month) {
			this.month = month;
		}


		/**
		 * @return the year
		 */
		public String getYear() {
			return year;
		}


		/**
		 * @param year the year to set
		 */
		public void setYear(String year) {
			this.year = year;
		}
		
		
}
