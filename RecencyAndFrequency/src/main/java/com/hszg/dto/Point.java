package com.hszg.dto;

public class Point {

	private float x;
	private float y;
	
	/**
	 * Constructor to create new Point object.
	 * @param x - The x value of the point.
	 * @param y - The y value of the point.
	 */
	public Point(float x, float y ){
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	
	
}
