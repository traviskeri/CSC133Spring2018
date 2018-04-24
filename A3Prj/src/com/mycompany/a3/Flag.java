package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Flag extends Fixed implements IDrawable, ICollider{
	
	private int sequenceNumber;
	private String name = "Flag";
	private boolean isColliding;
	
	/**
	 * This is the constructor for Flag it calls the constructor for Fixed to set the fields that can not be changed
	 * then sets the rest of the fields
	 * @param sequenceNumber int
	 * @param size int
	 * @param color int
	 * @param x float
	 * @param y float
	 */
	public Flag(int sequenceNumber, int size, int color, int x, int y, boolean isSelected) {
		super(x, y, color, size, isSelected);
		this.sequenceNumber = sequenceNumber;
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		if(this.isSelected()) {
			int [] xVals = {(int)pCmpRelPrnt.getX()+(int)this.getX(), (int)pCmpRelPrnt.getX()+(int)this.getX()+(this.getSize()/2), 
							(int)pCmpRelPrnt.getX()+(int)this.getX()+this.getSize() };
			int [] yVals = {(int)pCmpRelPrnt.getY()+(int)this.getY(), (int)pCmpRelPrnt.getY()+(int)this.getY()+this.getSize(), 
							(int)pCmpRelPrnt.getY()+(int)this.getY()};
			g.setColor(ColorUtil.WHITE);
			g.fillPolygon(xVals, yVals, 3);
			g.setColor(ColorUtil.BLACK);
			g.drawString(""+this.getSequenceNumber(), (int)pCmpRelPrnt.getX()+(int)this.getX()+40, 
						(int)pCmpRelPrnt.getY()+(int)this.getY()+30);
		}
		else {
			int [] xVals = {(int)pCmpRelPrnt.getX()+(int)this.getX(), (int)pCmpRelPrnt.getX()+(int)this.getX()+(this.getSize()/2), 
							(int)pCmpRelPrnt.getX()+(int)this.getX()+this.getSize() };
			int [] yVals = {(int)pCmpRelPrnt.getY()+(int)this.getY(), (int)pCmpRelPrnt.getY()+(int)this.getY()+this.getSize(), 
							(int)pCmpRelPrnt.getY()+(int)this.getY()};
			g.setColor(this.getColor());
			g.fillPolygon(xVals, yVals, 3);
			g.setColor(ColorUtil.BLACK);
			g.drawString(""+this.getSequenceNumber(), (int)pCmpRelPrnt.getX()+(int)this.getX()+40, 
						(int)pCmpRelPrnt.getY()+(int)this.getY()+30);
		}
	}
	/**
	 * This method overrides the toString method in Fixed
	 * It addes the name and the flags sequence number then calls super.toString to add on the rest of the information
	 * @return String
	 */
	@Override
	public String toString() {
		String rv;
		rv = name + super.toString() + " seqNum=" + this.getSequenceNumber();
		return rv;
	}
	
	/**
	 * This method overrides the setColor method because it is not allowed to change color
	 */
	@Override
	public void setColor(int color) {}

	/**
	 * This method returns the sequence number of the flag.
	 * @return int
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * This method sets the sequence number of the flag
	 * @param sequenceNumber int 
	 */
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public boolean collidesWith(ICollider cObj) {
		// TODO Auto-generated method stub
		return false;
	}

	public void handleCollision(ICollider cObj) {
		// TODO Auto-generated method stub
		
	}

	public boolean isColliding() {
		return isColliding;
	}

	public void setColliding(boolean isColliding) {
		this.isColliding = isColliding;
	}
}
