package com.mycompany.a2;

import java.util.ArrayList;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;

import java.util.Observable;

/**
 * 
 * @author Travis Keri
 * @version 1.0
 */
public class GameWorld extends Observable {
	
	private float maxX = 1024;
	private float maxY = 768;
	private int clock = 0;
	private int lives = 3;
	private boolean exitSelected = false;
	private GameObjectCollection theCollection;
	private Ladybug lb;
	private int numberOfSpiders = 3;
	private ArrayList<Spider> spiders;
	private int numberOfFlags = 5;
	private ArrayList<Flag> flags;
	private int numberOfFoodStations = 2;
	private ArrayList<FoodStation> foodStations;
	private int foodStationSize;
	private boolean sound = true;
	
	

	
	/**
	 * This is the init method called in Game to create all of the game objects
	 */
	public void init() {
						
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		
		theCollection= new GameObjectCollection();		
		
		theCollection.add(lb = Ladybug.getLadybug(10, 10, 1, 10, 1, 0, 1, 2, ColorUtil.rgb(255, 0, 0), 100, 100 ));
		
		spiders = new ArrayList<Spider>();
		for(int i = 0; i < numberOfSpiders; i++) {
			spiders.add(new Spider(5, 2, randomSize(rnd.nextInt()), ColorUtil.BLACK, randomX(rnd.nextInt()), randomY(rnd.nextInt())));
			theCollection.add(spiders.get(i));
		}
		
		flags = new ArrayList<Flag>();
		for(int i = 0; i < numberOfFlags; i++) {
			flags.add(new Flag(i+1, 2, ColorUtil.BLUE, 100 + 200 * i, 100 + 100 * i));
			theCollection.add(flags.get(i));
		}
		
		foodStations = new ArrayList<FoodStation>();
		for(int i = 0; i < numberOfFoodStations; i++) {
			foodStationSize = randomSize(rnd.nextInt());
			foodStations.add(new FoodStation(foodStationCapacity(foodStationSize), foodStationSize, ColorUtil.GREEN, 
							randomX(rnd.nextInt()), randomY(rnd.nextInt())));
			theCollection.add(foodStations.get(i));
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
		setChanged();
		notifyObservers();
	}
	
	/**
	 * This method decreases the speed of the ladybug by 1
	 */
	public void slowDown() {
		if(lb.getSpeed() > 0) {
			lb.setSpeed(lb.getSpeed()-1);
		}
		setChanged();
		notifyObservers();
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
		setChanged();
		notifyObservers();
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
		for(int i = 0; i < foodStations.size(); i++) {
			System.out.println(foodStations.get(i).getCapacity());
			if(foodStations.get(i).getCapacity() != 0) {
				 lb.setFoodLevel(lb.getFoodLevel() + foodStations.get(i).getCapacity());
				 foodStations.get(i).setCapacity(0);
				 foodStations.get(i).setColor(ColorUtil.rgb(50,205,50));
				 break;
				}
		}


		
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		foodStationSize = randomSize(rnd.nextInt());
		
		FoodStation fs = new FoodStation(foodStationCapacity(foodStationSize), foodStationSize, ColorUtil.GREEN, 
										randomX(rnd.nextInt()), randomY(rnd.nextInt()));
		
		theCollection.add(fs);
		foodStations.add(fs);
		setChanged();
		notifyObservers();
	}
				
	/**
	 * This method increases clock by 1.
	 */
	public void clockTick() {
		clock++;
		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * This method uses a for loop to go through gameObjects looking for movable objects.
	 * If that object is a Spider it changes the heading by random number between -5 and 5.
	 * Then moves the movable objects, check for objects going off the screen.
	 */
	public void move() {
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
		IIterator theElements = theCollection.getIterator();
		while(theElements.hasNext()) {
			if(theElements.checkNext() instanceof Movable) {
				Movable mObj = (Movable)theElements.getNext();
				if(theElements.checkNext() instanceof Spider) {
					Spider sObj =(Spider)theElements.getNext();
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
			theElements.getNext();
		}
		setChanged();
		notifyObservers();
	}
		
	/**
	 * This method turns the ladybug 5 degrees to the left
	 */
	public void turnLeft() {
		lb.steer(-5);
		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * This method turns the ladybug 5 degrees to the right.
	 */
	public void turnRight() {
		lb.steer(5);
		setChanged();
		notifyObservers();
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
		setChanged();
		notifyObservers();
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
		IIterator theElements = theCollection.getIterator();
		while(theElements.hasNext()) {
				System.out.println(theElements.getNext().toString());
		}
	
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
		if(lb.getFoodLevel() == 0 || lb.getHealthLevel() == 0 && lives != 0) {
			System.out.println("You've lost a life!");
			makeNewGame();
			
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
		theCollection.clear();
		spiders.clear();
		flags.clear();
		foodStations.clear();	
		lb.deleteLadybug();
		init();
		clock = 0;
		lives--;
		setChanged();
		notifyObservers();
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

	/**
	 * Gets the amount of lives left
	 * @return lives int
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * Gets the value for clock
	 * @return clock in
	 */
	public int getClock() {
		return clock;
	}
	
	/**
	 * Gets the last flag reached by the ladybug
	 * @return lb.getLastFlagReached int
	 */
	public int getLastFlagReached() {
		return lb.getLastFlagReached();
	}
	
	/**
	 * Gets the food level of ladybug
	 * @return lb.getFoodLevel int
	 */
	public int getLBFood() {
		return lb.getFoodLevel();
	}
	
	/**
	 * Gets the health level of the ladybug
	 * @return lb.getHealthLevel int
	 */
	public int getLBHealth() {
		return lb.getHealthLevel();
	}

	/**
	 * Returns the value of sound
	 * @return sound boolean
	 */
	public boolean isSound() {
		return sound;
	}

	/**
	 * Set the value of sound
	 * @param sound boolean
	 */
	public void setSound(boolean sound) {
		this.sound = sound;
		setChanged();
		notifyObservers();
	}
	
	public void setMaxX(int x) {
		maxX = x;
	}
	
	public float getMaxX() {
		return maxX;
	}
	
	
	public void setMaxY(int y) {
		maxY = y;
	}
	
	public float getMaxY() {
		return maxY;
	}
}