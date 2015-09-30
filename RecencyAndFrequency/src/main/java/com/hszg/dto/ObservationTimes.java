package com.hszg.dto;

import java.util.ArrayList;
import java.util.List;

public class ObservationTimes {

	public static class ObservationTime{
		
		private SingleObservationTime start;
		private SingleObservationTime end;
		
		public ObservationTime() {
			this.start = new SingleObservationTime();
			this.end   = new SingleObservationTime();
		}

		/**
		 * @return the start
		 */
		public SingleObservationTime getStart() {
			return start;
		}

		/**
		 * @param start the start to set
		 */
		public void setStart(SingleObservationTime start) {
			this.start = start;
		}

		/**
		 * @return the end
		 */
		public SingleObservationTime getEnd() {
			return end;
		}

		/**
		 * @param end the end to set
		 */
		public void setEnd(SingleObservationTime end) {
			this.end = end;
		}
		
		
	}
	
	private String clientMac;
	private List<ObservationTime> times;
	
	/**
	 * 
	 **/
	public ObservationTimes() {
		clientMac = "";
		times = new ArrayList<ObservationTime>();
	}
	
	/**
	 * 
	 **/
	public void add(ObservationTime observationTime){
		this.times.add(observationTime);
	}

	/**
	 * @return the clientMac
	 */
	public String getClientMac() {
		return clientMac;
	}

	/**
	 * @param clientMac the clientMac to set
	 */
	public void setClientMac(String clientMac) {
		this.clientMac = clientMac;
	}

	/**
	 * @return the times
	 */
	public List<ObservationTime> getTimes() {
		return times;
	}

	/**
	 * @param times the times to set
	 */
	public void setTimes(List<ObservationTime> times) {
		this.times = times;
	}
	
	
	
	
}
