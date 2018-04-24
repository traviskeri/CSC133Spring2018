package com.mycompany.a1;

public abstract class Fixed extends GameObject{
	
	/**
	 * This is a constructor for Fixed, this one is called by Flag
	 * @param x float
	 * @param y float
	 * @param color int
	 * @param size int
	 */
	public Fixed(float x, float y, int color, int size) {
		super.setX(x);
		super.setY(y);
		super.setColor(color);
		super.setSize(size);
	}
	
	/**
	 * This is a constructor for Fixed, this one is called by FoodStation
	 * @param x float
	 * @param y float
	 * @param size int
	 */
	public Fixed(float x, float y, int size) {
		super.setX(x);
		super.setY(y);
		super.setSize(size);
	}

	/**
	 * This method overrides setX to do nothing
	 */
	@Override
	public void setX(float x) {}
	
	/**
	 * This method overrides setY to do nothing
	 */
	@Override
	public void setY(float x) {}
	
	/**
	 * This method overrides setSize to do nothing
	 */
	@Override 
	public void setSize(int size) {}
}
