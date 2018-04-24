package com.mycompany.a3;

import com.codename1.charts.models.Point;

public abstract class Fixed extends GameObject implements ISelectable{
	
	private boolean isSelected;

	/**
	 * This is a constructor for Fixed, this one is called by Flag
	 * @param x float
	 * @param y float
	 * @param color int
	 * @param size int
	 */
	public Fixed(float x, float y, int color, int size, boolean isSelected) {
		super.setX(x);
		super.setY(y);
		super.setColor(color);
		super.setSize(size);
		this.isSelected= isSelected;
	}
	
	/**
	 * This is a constructor for Fixed, this one is called by FoodStation
	 * @param x float
	 * @param y float
	 * @param size int
	 */
	public Fixed(float x, float y, int size, boolean isSelected) {
		super.setX(x);
		super.setY(y);
		super.setSize(size);
		this.isSelected();
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
	
	public void setSelected(boolean set) {
		this.isSelected = set;	
	}

	public boolean isSelected() {
		return this.isSelected;
	}

	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int px = (int) pPtrRelPrnt.getX(); // pointer location relative to
		int py = (int) pPtrRelPrnt.getY(); // parent’s origin
		int xLoc = (int) (pCmpRelPrnt.getX()+ this.getX());// shape location relative 
		int yLoc = (int) (pCmpRelPrnt.getY()+ this.getY());// to parent’s origin
		if ( (px >= xLoc) && (px <= xLoc+this.getSize())&& (py >= yLoc) && (py <= yLoc+this.getSize()) )
		        return true; 
		else
		        return false;
		
	}
	
	public void sSetX(int x){
		super.setX(x);
	}
	
	public void sSetY(int y){
		super.setY(y);
	}
}
