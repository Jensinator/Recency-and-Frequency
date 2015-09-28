package com.hszg.dto;

import java.util.ArrayList;
import java.util.List;

public class RecencyDistribution {
	
	public static class Point{
		
		private int x;
		private int y;
		
		/**
		 *
		 */
		public Point( int x, int y){
			this.x = x;
			this.y = y;
		}

		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}

		/**
		 * @param x the x to set
		 */
		public void setX(int x) {
			this.x = x;
		}

		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}

		/**
		 * @param y the y to set
		 */
		public void setY(int y) {
			this.y = y;
		}
	}
	
	public static final int NO_RECENCY = -1;
	
	private List<Point> distribution;
	
	/**
	 *
	 */
	public RecencyDistribution(){
		distribution = new ArrayList<Point>();
	}
	
	
	/**
	 * 
	 */
	public List<Point> getDistribution(){
		return distribution;
	}
	
	
	/** This method adds a recency value to the distribution and 
	 *  adjust this one.
	 *	@recency - Value to add.
	 */
	public void addRecencyValue( int recency ){
		
		if( recency < NO_RECENCY ){
			throw new IllegalArgumentException("recency has to be positive value.");
		}
		
		// base case
		if( distribution.size() == 0 ){
			Point dataPoint = new Point(recency, 1);
			distribution.add(dataPoint);
		}
		
		
		for( int i = 0; i < distribution.size(); i++ ){
			
			if( distribution.get(i) == null ){
				continue;
			}

			if( recency == distribution.get(i).x ){
				distribution.get(i).y++;
				break;
			}
			
			if( recency > distribution.get(i).x){
				Point dataPoint = new Point(recency,1);
				distribution.add(i, dataPoint);
				break;
			}
			
		}
		
	}

	/** This method adds combines the current distribution with another one.
	 * 
	 * */
	public void add( RecencyDistribution distribution ){
		
		for( int i = 0; i < distribution.getDistribution().size(); i++ ){
			for( int j = 0; j < distribution.getDistribution().get(i).getY(); j++ ){
				addRecencyValue( distribution.getDistribution().get(i).getX() );
			}	
		}

	}
	
	/**
	 * 
	 * */
	public void addToFrequency( RecencyDistribution distribution ){
		
		for( int i = 0; i < distribution.getDistribution().size(); i++ ){
			addRecencyValue( distribution.getDistribution().get(i).getX() );
		}
		
	}
	
}
