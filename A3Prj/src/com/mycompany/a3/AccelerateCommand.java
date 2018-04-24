package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AccelerateCommand extends Command{
	
	private GameWorld gw;
	
	public AccelerateCommand(GameWorld gw) {
		super("Accelerate");
		this.gw =gw;
	}

	
	/**
	 * Calls the speedUp method in GameWorld
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.speedUp();
		//System.out.println("Speeding up");
		
	}
}
