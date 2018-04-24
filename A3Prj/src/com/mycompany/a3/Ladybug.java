package com.mycompany.a3;

import java.util.ArrayList;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

/**
 * 
 * @author Travis Keri
 * @version 1.0
 */

public class Ladybug extends Movable implements ISteerable, IDrawable, ICollider{
	
	private String name = "Ladybug";
	private int maxSpeed;
	private int foodLevel;
	private int foodConsumptionLevel;
	private int healthLevel;
	private int lastFlagReached;
	private static Ladybug theLadybug;
	
	
	/**
	 * This is the constructors for the Ladybug it calls the constructor for Movable to set the fields that can not be changed,
	 * then sets the rest of the fields.
	 * @param maxSpeed int
	 * @param foodLevel int
	 * @param foodConsumptionLevel int
	 * @param healthLevel int
	 * @param lastFlagReached int
	 * @param heading int
	 * @param speed int
	 * @param size int
	 * @param color int
	 * @param x float
	 * @param y float
	 */
	private Ladybug(int maxSpeed, int foodLevel, int foodConsumptionLevel, int healthLevel, int lastFlagReached, int heading, 
				   int speed, int size, int color, float x, float y) {
		super(size);
		this.maxSpeed = maxSpeed;
		this.foodLevel = foodLevel;
		this.foodConsumptionLevel = foodConsumptionLevel;
		this.healthLevel = healthLevel;
		this.lastFlagReached = lastFlagReached;
		this.setHeading(heading);
		this.setSpeed(speed);
		this.setColor(color);
		this.setX(x);
		this.setY(y);
	}
	
	public static Ladybug getLadybug(int maxSpeed, int foodLevel, int foodConsumptionLevel, int healthLevel, int lastFlagReached, int heading,
									int speed, int size, int color, float x, float y) {
		if (theLadybug == null)
		theLadybug = new Ladybug(maxSpeed, foodLevel, foodConsumptionLevel, healthLevel, lastFlagReached, heading, speed, size, color, x, y);
		return theLadybug;
		}
	
	public void deleteLadybug() {
		theLadybug = null;
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(this.getColor());
		g.fillArc( (int)(pCmpRelPrnt.getX()+this.getX()), (int)(pCmpRelPrnt.getY()+this.getY()), this.getSize(), this.getSize(), 0, 360);
	}
	
	/**
	 * This method is to steer the ladybug,
	 * it takes the old heading and and adds the amount you want to turn
	 */
	public void steer(int newHeading) {
		this.setHeading(this.getHeading() + newHeading);		
	}
	
	/**
	 * This method overrides the toString in Movable.
	 * It then calls the toString in Movable and adds the name, max speed and the food consumption level
	 * @return String
	 */
	@Override
	public String toString() {
		String rv;
		rv = name + super.toString() + " maxSpeed=" + this.getMaxSpeed() + " foodConsumptionRate=" + this.getFoodConsumptionLevel();
		
		return rv;
	}
	
	/**
	 * This methods displays the last flag reached the food level and the health of the ladybug
	 * @return
	 */
	public String display() {
		String rv;
		rv = " Last Flag Reached:" + getLastFlagReached() + " Food Level:" + getFoodLevel() + " Health:" + getHealthLevel();
		return rv;
	}
	
	/**
	 * This method is for getting the value in maxSpeed
	 * @return int returns the value of maxSpeed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * This method is for setting the value in maxSpeed
	 * @param maxSpeed This is new maxSpeed
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * This method is for getting the value in foodLevel
	 * @return int return the value of foodLevel
	 */
	public int getFoodLevel() {
		return foodLevel;
	}

	/**
	 * This method is for setting the value in foodLevel
	 * @param foodLevel this is the new food level for the ladybug
	 */
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}

	/**
	 * This method is for getting the value in foodConsumptionLevel
	 * @return int returns the value of foodConsumptionLevel
	 */
	public int getFoodConsumptionLevel() {
		return foodConsumptionLevel;
	}

	/**
	 * This method is for setting the value in foodConsumptionLevel
	 * @param foodConsumptionLevel 
	 */
	public void setFoodConsumptionLevel(int foodConsumptionLevel) {
		this.foodConsumptionLevel = foodConsumptionLevel;
	}

	/**
	 * This method is for getting the value in healthLevel
	 * @return
	 */
	public int getHealthLevel() {
		//System.out.println("get");
		return healthLevel;
	}

	/**
	 * This method is for setting the value in healthLevel
	 * @param healthLevel
	 */
	public void setHealthLevel(int healthLevel) {
		//System.out.println("set");
		this.healthLevel = healthLevel;
	}

	/**
	 * This method is for getting the value in lastFlagReached
	 * @return
	 */
	public int getLastFlagReached() {
		return lastFlagReached;
	}

	/**
	 * This method is for setting the value in lastFlagReached
	 * @param lastFlagReached
	 */
	public void setLastFlagReached(int lastFlagReached) {
		this.lastFlagReached = lastFlagReached;
	}

	public boolean collidesWith(ICollider cObj) {
		
		boolean result = false;
		int thisCenterX = (int)this.getX() +(this.getSize()/2);
		int thisCenterY = (int)this.getY() +(this.getSize()/2);
		int otherCenterX = (int)((GameObject) cObj).getX() +(((GameObject) cObj).getSize()/2);
		int otherCenterY = (int)((GameObject) cObj).getY() +(((GameObject) cObj).getSize()/2);
		
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		int dBetweenCentersSqr = dx*dx+dy*dy;
		
		int thisRadius = this.getSize()/2;
		int otherRadius = ((GameObject)cObj).getSize()/2;
		int radiiSqr = (thisRadius+otherRadius)*(thisRadius+otherRadius);
		
		if(dBetweenCentersSqr <= radiiSqr) {result = true;}		
		
		return result;
	}

	public void handleCollision(ICollider cObj) {
		if(cObj instanceof Spider) {
			lowerHealth();
			lowerMaxSpeed();
			fadeColor();
		}
		else if(cObj instanceof Flag) {
			if(this.getLastFlagReached() + 1 == ((Flag) cObj).getSequenceNumber()) {
				this.setLastFlagReached(this.getLastFlagReached() + 1);
			}
		}
		else if(cObj instanceof FoodStation) {
			if(((FoodStation) cObj).isCollidable()) {
				this.setFoodLevel(this.getFoodLevel() + ((FoodStation) cObj).getCapacity());
				((FoodStation) cObj).setCapacity(0);
				((GameObject) cObj).setColor(ColorUtil.rgb(150,255,150));
				((FoodStation) cObj).setCollidable(false);
			}
		}	
	}
	
	public void fadeColor() {
		this.setColor(ColorUtil.rgb(255 - (10 - this.getHealthLevel()) * 10, (10 - this.getHealthLevel()) * 10, (10 - this.getHealthLevel()) * 10));
	}
	
	/**
	 * This method decreases the health of the ladybug by 1
	 */
	public void lowerHealth() {
		if(this.getHealthLevel() > 0) {
			this.setHealthLevel(this.getHealthLevel()-1);
		}
	}
	
	/**
	 * This method decreases the max speed of the ladybug by 1
	 */
	public void lowerMaxSpeed() {
		if(this.getMaxSpeed() > 0) {
			this.setMaxSpeed(this.getMaxSpeed()-1);
		}
		if(this.getSpeed()>this.getMaxSpeed()) {
			slowDown();
		}
	}
	
	public void slowDown() {
		if(this.getSpeed() > 0) {
			this.setSpeed(this.getSpeed()-1);
		}
	}
}
