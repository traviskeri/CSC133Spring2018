package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.ui.Graphics;

/**
 * 
 * @author Travis Keri
 * @version 1.0
 */
public class Spider extends Movable implements IDrawable, ICollider{
	
	private String name = "Spider";
	
	
	/**
	 * This is the constructor for Spider. It calls the calls the constructor to set the fields that can not be changed,
	 * then sets the rest of the fields.
	 * @param heading int
	 * @param speed int
	 * @param size int
	 * @param color int
	 * @param x float
	 * @param y float
	 */
	public Spider(int heading, int speed, int size, int color, float x, float y) {
		super(color, size);
		this.setHeading(heading);
		this.setSpeed(speed);
		this.setX(x);
		this.setY(y);
	}

	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int [] xVals = {(int)pCmpRelPrnt.getX()+(int)this.getX(), (int)pCmpRelPrnt.getX()+(int)this.getX()+(this.getSize()/2), 
						(int)pCmpRelPrnt.getX()+(int)this.getX()+this.getSize() };
		int [] yVals = {(int)pCmpRelPrnt.getY()+(int)this.getY(), (int)pCmpRelPrnt.getY()+(int)this.getY()+this.getSize(), 
						(int)pCmpRelPrnt.getY()+(int)this.getY()};
		g.setColor(this.getColor());
		g.drawPolygon(xVals, yVals, 3);
	}
	/**
	 * This method overrides the toString method.
	 * It adds the name and then calls super.toString
	 * @return String
	 */
	@Override
	public String toString() {
		String rv;
		rv = name + super.toString();
		return rv;
	}
	
	/**
	 * This method overrides the setColor method to do nothing.
	 */
	@Override
	public void setColor(int color) {}


	public boolean collidesWith(ICollider cObj) {
		return false;
	}


	public void handleCollision(ICollider cObj) {
		
		
	}

}
