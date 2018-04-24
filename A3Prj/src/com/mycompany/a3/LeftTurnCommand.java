package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class LeftTurnCommand extends Command{
	
	private GameWorld gw;

	public LeftTurnCommand(GameWorld gw) {
		super("Turn Left");
		this.gw = gw;
	}
	
	/**
	 * Calls the turnLeft method in GameWorld
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.turnLeft();
		//System.out.println("Turning Left");
		
	}
}
