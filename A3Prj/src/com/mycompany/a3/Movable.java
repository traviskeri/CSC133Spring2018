package com.mycompany.a3;

/**
 * 
 * @author Travis Keri
 *@version 1.0
 */
public abstract class Movable extends GameObject{
	private int heading;
	private int speed;
	
	/**
	 * This is a constructor for movable that takes in a color and size. Then sets them using the mutators in GameObject.
	 * This is used in the constructor for the Spider
	 * @param color int
	 * @param size int
	 */
	public Movable(int color, int size) {
		super.setColor(color);
		super.setSize(size);
	}
	
	/**
	 * This is a constructor for movable that just takes in size. Then sets is using the mutator in GameObject.
	 * This is used int he constructor for Ladybug.
	 * @param size this
	 */
	public Movable(int size) {
		super.setSize(size);
	}
	
	/**
	 * This method first mods the current heading to make sure its between 0 and 359.
	 * Then it figures out the delta x and y by converting the heading to radians.
	 * Calling cos for x and sin for y and multiplying them by their speed.
	 * Then takes those new values and adds them to their old x and y.
	 */
	public void move(int time) {
		float deltaX, deltaY;
		
		this.setHeading(this.getHeading() % 359);
		
		deltaX = (float)Math.cos(90 -Math.toRadians(heading)) * speed * time / 50;
		deltaY = (float)Math.sin(90- Math.toRadians(heading)) * speed * time / 50;
		
		this.setX(this.getX()+deltaX);
		this.setY(this.getY()+deltaY);
	}
	
	/**
	 * This method calls the toString method in GameObjects then adds on the heading and the speed
	 * @return String
	 */
	public String toString() {
		String rv;
		rv = super.toString() + " heading=" + this.getHeading() + " speed=" + this.getSpeed();
		return rv;
	}
	
	/**
	 * This method overrides the set size in GameObject to do nothing
	 */
	@Override
	public void setSize(int size) {}
	
	/**
	 * This method returns the value in heading
	 * @return int
	 */
	public int getHeading() {
		return heading;
	}
	
	/**
	 * This method sets the heading
	 * @param heading int
	 */
	public void setHeading(int heading) {
		this.heading = heading;
	}
	
	/**
	 * This method gets the value in speed
	 * @return int
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * This method sets the value in speed
	 * @param speed int
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	

}
