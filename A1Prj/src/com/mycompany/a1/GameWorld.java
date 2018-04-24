package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;

/**
 * 
 * @author Travis Keri
 * @version 1.0
 */
public class GameWorld {
	
	private float maxX = 1024;
	private float maxY = 768;
	private int clock = 0;
	private int lives = 3;
	private boolean exitSelected = false;
	private Ladybug lb;
	private int numberOfSpiders = 3;
	private ArrayList<Spider> spiders;
	private int numberOfFlags = 5;
	private ArrayList<Flag> flags;
	private int numberOfFoodStations = 2;
	private ArrayList<FoodStation> foodStations;
	private ArrayList<GameObject> gameObjects;
	private int foodStationSize;
	
	

	
	/**
	 * This is the init method called in Game to create all of the game objects
	 */
	public void init() {
						
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		
		gameObjects = new ArrayList<GameObject>();
		
		gameObjects.add(lb = new Ladybug(10, 10, 1, 10, 1, 0, 1, 2, ColorUtil.rgb(255, 0, 0), 100, 100 ));
		
		spiders = new ArrayList<Spider>();
		for(int i = 0; i < numberOfSpiders; i++) {
			spiders.add(new Spider(5, 2, randomSize(rnd.nextInt()), ColorUtil.BLACK, randomX(rnd.nextInt()), randomY(rnd.nextInt())));
			gameObjects.add(spiders.get(i));
		}
		
		flags = new ArrayList<Flag>();
		for(int i = 0; i < numberOfFlags; i++) {
			flags.add(new Flag(i+1, 2, ColorUtil.BLUE, 100 + 200 * i, 100 + 100 * i));
			gameObjects.add(flags.get(i));
		}
		
		foodStations = new ArrayList<FoodStation>();
		for(int i = 0; i < numberOfFoodStations; i++) {
			foodStationSize = randomSize(rnd.nextInt());
			foodStations.add(new FoodStation(foodStationCapacity(foodStationSize), foodStationSize, ColorUtil.GREEN, 
							randomX(rnd.nextInt()), randomY(rnd.nextInt())));
			gameObjects.add(foodStations.get(i));
		}
	}
	
	/**
	 * This method takes a random int mods it by 40 adds 10 and returns the absolute value to crate the size of spiders and the food station
	 * @param rnd int
	 * @return int
	 */
	public int randomSize(int rnd) {
		return Math.abs((rnd % 40) + 10);
	}
	
	/**
	 * This method creates a random value for x by taking a random number modding it by the maxX and returnig the absolute value
	 * @param rnd float
	 * @return float random x from 0 to 1024
	 */
	public float randomX(float rnd) {
		return Math.abs(rnd % maxX);
	}
	
	/**
	 * This method creates a random value for y by taking a random number modding it by the maxX and returnig the absolute value
	 * @param rnd float
	 * @return float random y from 0 768
	 */
	public float randomY(float rnd) {
		return Math.abs(rnd % maxY);
	}
	
	/**
	 * This method creates a value for the capacity of the food station based on the food station size and dividing it by 2
	 * @param foodStationSize int
	 * @return int size divided by 2
	 */
	public int foodStationCapacity(int foodStationSize) {
		return foodStationSize/2;
	}
	
	/**
	 * This method increases the speed of the ladybug by 1
	 */
	public void speedUp() {
		if(lb.getSpeed() < lb.getMaxSpeed()) {
			lb.setSpeed(lb.getSpeed()+1);
		}
	}
	
	/**
	 * This method decreases the speed of the ladybug by 1
	 */
	public void slowDown() {
		if(lb.getSpeed() > 0) {
			lb.setSpeed(lb.getSpeed()-1);
		}
	}
	
	/**
	 * This method decreases the health of the ladybug by 1
	 */
	public void lowerHealth() {
		if(lb.getHealthLevel() > 0) {
			lb.setHealthLevel(lb.getHealthLevel()-1);
		}
	}
	
	/**
	 * This method decreases the max speed of the ladybug by 1
	 */
	public void lowerMaxSpeed() {
		if(lb.getMaxSpeed() > 0) {
			lb.setMaxSpeed(lb.getMaxSpeed()-1);
		}
		if(lb.getSpeed()>lb.getMaxSpeed()) {
			slowDown();
		}
	}
	
	/**
	 * This method simulates a collision with a spider. 
	 * This lowers the health and max speed of the ladybug and fades its color
	 */
	public void hitSpider() {
		lowerHealth();
		lowerMaxSpeed();
		lb.setColor(ColorUtil.rgb(255 - (10 - lb.getHealthLevel()) * 10, (10 - lb.getHealthLevel()) * 10, (10 - lb.getHealthLevel()) * 10));
		
	}
	
	/**
	 * This method decreases the food level of the ladybug
	 */
	public void lowerFoodLevel() {
		lb.setFoodLevel(lb.getFoodLevel()-lb.getFoodConsumptionLevel());
	}
	
	/**
	 * This method simulates a collision with the food station. 
	 * It checks for the first non empty food station, 
	 * increases the food level of ladybug by the capacity,
	 * then sets the capacity of the food station to 0,
	 * and fades the color of the food station.
	 * It then creates a new food station and adds it to the gameObjects and foodStations ArrayLists.
	 */
	public void eat() {
		for(int i = 0; i < numberOfFoodStations; i++) {
			if(foodStations.get(i).getCapacity() != 0) {
				 lb.setFoodLevel(lb.getFoodLevel() + foodStations.get(i).getCapacity());
				 foodStations.get(i).setCapacity(0);
				 foodStations.get(i).setColor(ColorUtil.rgb(50,205,50));
				 break;
				}
		}


		
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		
		FoodStation fs = new FoodStation(foodStationCapacity(foodStationSize), foodStationSize, ColorUtil.GREEN, 
										randomX(rnd.nextInt()), randomY(rnd.nextInt()));
		
		gameObjects.add(fs);
		foodStations.add(fs);
	}
				
	/**
	 * This method increases clock by 1.
	 */
	public void clockTick() {
		clock++;
	}
	
	/**
	 * This method uses a for loop to go through gameObjects looking for movable objects.
	 * If that object is a Spider it changes the heading by random number between -5 and 5.
	 * Then moves the movable objects, check for objects going off the screen.
	 */
	public void move() {
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Movable) {
				Movable mObj = (Movable)gameObjects.get(i);
				if(gameObjects.get(i) instanceof Spider) {
					Spider sObj =(Spider)gameObjects.get(i);
					sObj.setHeading(sObj.getHeading() + (rnd.nextInt() % 10 - 5));
				}
				mObj.move();
				if(mObj.getX() > maxX) {
					mObj.setX(maxX);
				}
				else if(mObj.getX() < 0) {
					mObj.setX(0);
				}
				else if(mObj.getY() > maxY) {
					mObj.setY(maxY);
				}
				else if(mObj.getY() < 0) {
					mObj.setY(0);
				}
			}
		}
	}
		
	/**
	 * This method turns the ladybug 5 degrees to the left
	 */
	public void turnLeft() {
		lb.steer(-5);
		
	}
	
	/**
	 * This method turns the ladybug 5 degrees to the right.
	 */
	public void turnRight() {
		lb.steer(5);		
	}
	
	/**
	 * This method simulates a collision with a flag.
	 * First it checks the if the flag is the next flag.
	 * Then it needs checks to see if you won
	 * @param f int, the sequence number of the flag you collided with.
	 */
	public void hitFlag(int f) {
		if(lb.getLastFlagReached() + 1 == flags.get(f-1).getSequenceNumber()) {
			lb.setLastFlagReached(lb.getLastFlagReached() + 1);
		}
		checkGameOver();
	}
	
	/**
	 * This method displays the lives left and the clock then calls the display method in Ladybug
	 */
	public void displayStats() {
		System.out.println("Lives:" + lives + " Time:" + clock + lb.display());
		
		
	}
	
	/**
	 * This method does a for loop to run through the gameObjects ArrayList 
	 * then calls toString on each object and prints it out to the console
	 */
	public void map() {
		for(int i = 0; i < gameObjects.size(); i++) 
			System.out.println(gameObjects.get(i).toString());
	}
	
	/**
	 * This method exits the game.
	 */
	public void exit() {
		System.exit(0);
		
	}
	
	/**
	 * This method checks 3 conditions
	 * 1:If your foodLevel of healthLevel reach 0 you lose a life and the game world is recreated.
	 * 2:If you reach the last flag it prints that you win the game.
	 * 3:If your lives reach 0 if prints that you failed.
	 */
	public void checkGameOver() {
		if(lb.getFoodLevel() == 0 || lb.getHealthLevel() == 0) {
			System.out.println("You've lost a life!");
			makeNewGame();
			init();
			lives--;
			clock = 0;
		}
		if(lb.getLastFlagReached() == 5) {
			System.out.println("Game over, you win! Total time: " + clock);
			exit();
		}
		if(lives == 0) {
			System.out.println("Game over, you failed!");
			exit();
		}
	}
	
	/**
	 * This method creates a new game.
	 * First it clears all of the ArrayLists
	 */
	public void makeNewGame() {
		gameObjects.clear();
		spiders.clear();
		flags.clear();
		foodStations.clear();	
	}

	/**
	 * This method return if exit has been selected
	 * @return boolean exitSelected
	 */
	public boolean isExitSelected() {
		return exitSelected;
	}

	/**
	 * This method sets exitSelected to true or false
	 * @param exitSelected boolean
	 */
	public void setExitSelected(boolean exitSelected) {
		this.exitSelected = exitSelected;
	}
}