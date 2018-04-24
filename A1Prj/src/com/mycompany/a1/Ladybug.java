package com.mycompany.a1;

/**
 * 
 * @author Travis Keri
 * @version 1.0
 */

public class Ladybug extends Movable implements ISteerable{
	
	private String name = "Ladybug";
	private int maxSpeed;
	private int foodLevel;
	private int foodConsumptionLevel;
	private int healthLevel;
	private int lastFlagReached;
	
	
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
	public Ladybug(int maxSpeed, int foodLevel, int foodConsumptionLevel, int healthLevel, int lastFlagReached, int heading, 
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
}
