package com.hszg.dto;

import java.util.ArrayList;
import java.util.List;

public class Distribution {
	
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
		
		@Override
		public boolean equals( Object o ){
			
			if ( o == null )
				return false;

			if ( o == this )
				return true;
			
			Point point = (Point) o;
			
			if( this.getX() != point.getX() )
				return false;
			if( this.getY() != point.getY() )
				return false;
			
			return true;
		}
	}
	
	public static final int NO_RECENCY = -1;
	
	private List<Point> distribution;
	
	/** Constructor to create an empty distribution.
	 *
	 */
	public Distribution(){
		distribution = new ArrayList<Point>();
	}
	
	
	/** Return the data of the distribution.
	 *  @return distribution as sorted list.
	 */
	public List<Point> getDistribution(){
		return distribution;
	}
	
	
	/** This method adds a recency value to the distribution and 
	 *  adjust this one. The resulting distribution is always sorted.
	 *	@recency - Value to add.
	 */
	public void addValue( int recency ){
		
		if( recency < NO_RECENCY ){
			throw new IllegalArgumentException("recency has to be positive value.");
		}
		
		// base case
		if( distribution.size() == 0 ){
			Point dataPoint = new Point(recency, 1);
			distribution.add(dataPoint);
			return;
		}
		
		// check first element
		if( distribution.size() >= 1 ){
			
			if( recency < distribution.get(0).x ){
				distribution.add(0, new Point(recency,1));
				return;
			
			}else if( recency == distribution.get(0).x){
				distribution.get(0).y++;
				return;
			}
			
		}
		
		// go throught list while recency is bigger
		for( int i = 0; i < distribution.size()-1; i++ ){
			
			if( distribution.get(i) == null ){
				continue;
			}

			if( recency == distribution.get(i+1).x ){
				distribution.get(i+1).y++;
				return;
			}
			
			if( recency < distribution.get(i+1).x){
				distribution.add(i+1, new Point(recency,1));
				return;
			}
			
		}
		
		// no value found in list, recency is biggest and will be pushed to the end
		distribution.add( new Point(recency, 1));
		
	}

	
	/** This method adds combines the current distribution with another one.
	 *	to create a recency distribution.
	 *	@param distribution - The distribution to combine with.
	 * */
	public void add( Distribution distribution ){
		
		for( int i = 0; i < distribution.getDistribution().size(); i++ ){
			for( int j = 0; j < distribution.getDistribution().get(i).getY(); j++ ){
				addValue( distribution.getDistribution().get(i).getX() );
			}	
		}

	}
	
	/** This method combines two distributions to create a frequency distribution.
	 *  @param distribution - The distribution to combine with.
	 * */
	public static Distribution addToFrequency( Distribution distribution1, Distribution distribution2 ){
		
		Distribution distribution = new Distribution();
		
		for( int i = 0; i < distribution1.getDistribution().size(); i++ ){
			distribution.addValue( distribution1.getDistribution().get(i).getX() );
		}
		
		for( int i = 0; i < distribution2.getDistribution().size(); i++ ){
			distribution.addValue( distribution2.getDistribution().get(i).getX() );
		}
		
		return distribution;
	}
	
}
