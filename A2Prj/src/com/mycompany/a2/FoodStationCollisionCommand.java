package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FoodStationCollisionCommand extends Command {
	
	private GameWorld gw;
	
	public FoodStationCollisionCommand(GameWorld gw) {
		super("Collied with food station");
		this.gw = gw;
	}
	
	/**
	 * Call eat method in GameWorld
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.eat();
		System.out.println("Eating");
		
	}

}
