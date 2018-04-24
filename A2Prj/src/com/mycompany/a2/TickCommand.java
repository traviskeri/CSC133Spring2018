package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TickCommand extends Command {
	
	private GameWorld gw;
	
	public TickCommand(GameWorld gw) {
		super("Tick");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.clockTick();
		gw.lowerFoodLevel();
		gw.checkGameOver();
		gw.move();
		System.out.println("clock tick, lower food level, move");
		
	}

}
