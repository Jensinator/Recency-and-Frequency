package com.hszg.dto;

public class ClassificationDistribution {

	private long passBy;
	private long passThru;
	private long visit;
	private long engaged;
	private long newCount;
	private long repeat;
	
	/**
	 *	Constructor 
	 **/
	public ClassificationDistribution(){
		this.passBy = 0;
		this.passThru = 0;
		this.visit = 0;
		this.engaged = 0;
		this.newCount = 0;
		this.repeat = 0;
	}
	
	
	/**
	 * @return the passBy
	 */
	public long getPassBy() {
		return passBy;
	}
	/**
	 * @param passBy the passBy to set
	 */
	public void setPassBy(long passBy) {
		this.passBy = passBy;
	}
	/**
	 * @return the passThrougth
	 */
	public long getPassThru() {
		return passThru;
	}
	/**
	 * @param passThrougth the passThrougth to set
	 */
	public void setPassThru(long passThrougth) {
		this.passThru = passThrougth;
	}
	/**
	 * @return the visit
	 */
	public long getVisit() {
		return visit;
	}
	/**
	 * @param visit the visit to set
	 */
	public void setVisit(long visit) {
		this.visit = visit;
	}
	/**
	 * @return the engaged
	 */
	public long getEngaged() {
		return engaged;
	}
	/**
	 * @param engaged the engaged to set
	 */
	public void setEngaged(long engaged) {
		this.engaged = engaged;
	}
	/**
	 * @return the newCount
	 */
	public long getNewCount() {
		return newCount;
	}
	/**
	 * @param newCount the newCount to set
	 */
	public void setNewCount(long newCount) {
		this.newCount = newCount;
	}
	/**
	 * @return the repeat
	 */
	public long getRepeat() {
		return repeat;
	}
	/**
	 * @param repeat the repeat to set
	 */
	public void setRepeat(long repeat) {
		this.repeat = repeat;
	}

}
