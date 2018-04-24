package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class FoodStation extends Fixed implements IDrawable, ICollider{
	
	private int capacity;
	private String name = "FoodStation";
	private boolean collidable;
	
	/**
	 * This is the constructor for the FoodStation. It calls the the constructor for Fixed to set fields that can not be changed.
	 * It then sets the rest of the fields
	 * @param capacity int
	 * @param size int
	 * @param color int
	 * @param x float
	 * @param y float
	 */
	public FoodStation(int capacity, int size, int color, float x, float y, boolean collidable) {
		super(x, y, size);
		this.capacity = capacity;
		this.setColor(color);
		this.setCollidable(collidable);
	}
	

	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(ColorUtil.GREEN);
		g.fillRect((int)pCmpRelPrnt.getX()+(int)this.getX(), (int)pCmpRelPrnt.getY()+(int)this.getY(), this.getSize(), this.getSize());
		g.setColor(ColorUtil.BLACK);
		g.drawString(""+this.getCapacity(), (int)pCmpRelPrnt.getX()+(int)this.getX()+(this.getSize()/2),
					(int)pCmpRelPrnt.getY()+(int)this.getY()+(this.getSize()/2));
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


	public boolean collidesWith(ICollider cObj) {
		return false;
	}


	public void handleCollision(ICollider cObj) {

	}


	public boolean isCollidable() {
		return collidable;
	}


	public void setCollidable(boolean collidable) {
		this.collidable = collidable;
	}

}
