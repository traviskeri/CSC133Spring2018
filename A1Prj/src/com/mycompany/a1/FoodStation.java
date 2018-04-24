package com.mycompany.a1;

public class FoodStation extends Fixed{
	
	private int capacity;
	private String name = "FoodStation";
	
	/**
	 * This is the constructor for the FoodStation. It calls the the constructor for Fixed to set fields that can not be changed.
	 * It then sets the rest of the fields
	 * @param capacity int
	 * @param size int
	 * @param color int
	 * @param x float
	 * @param y float
	 */
	public FoodStation(int capacity, int size, int color, float x, float y) {
		super(x, y, size);
		this.capacity = capacity;
		this.setColor(color);
		
	}
	
	/**
	 * This method overrides the toString method in Fixed
	 * It returns the name and capacity then calls super.toString
	 * @return String
	 */
	@Override
	public String toString() {
		String rv;
		rv = name + super.toString() + " capacity=" + this.getCapacity();
		return rv;
	}

	/**
	 * This method gets the value of capacity
	 * @return int
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * This method sets the value of the capacity
	 * @param capacity int
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
