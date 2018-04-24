package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
/**
 * 
 * @author Travis Keri
 * @version 1.0
 */
public abstract class GameObject {
	
	private float x;
	private float y;
	private int size;
	private int color;
		

	/**
	 * This method returns a string that includes the x, y, color, and size
	 * @return String 
	 */
	public String toString() {
		String rv;
		rv = ": loc=" + Math.round(this.getX()) + "," + Math.round(this.getY()) + " color = [" + 
		ColorUtil.red(this.getColor())+","+ ColorUtil.green(this.getColor())+ "," + ColorUtil.blue(this.getColor()) + 
		"] size =" + this.getSize();
		return rv;
	}
		
	/**
	 * This method returns the gameObjects location on the x-axis
	 * @return float returns the value of x
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * Sets a new location for the gameObjects on the x-axis
	 * @param x This is new value for the x-axis
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * This method returns the gameObjects location on the y-axis
	 * @return int returns the value of y
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Sets a new location for the gameObjects on the y-axis
	 * @param y This is the new value for the y-axis
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * This method returns the size of the gameObject
	 * @return int 
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * This method is to set the size of the gameObject
	 * @param size value to set size to
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * This method returns the integer value of the gameObject's color
	 * @return int 
	 */
	public int getColor() {
		return color;
	}
	
	/**
	 * This method sets the integer value of the gameObject's color
	 * @param color integer value for color
	 */
	public void setColor(int color) {
		this.color = color;
	}

}
