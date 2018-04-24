package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RightTurnCommand extends Command{
	
	private GameWorld gw;
	
	public RightTurnCommand(GameWorld gw) {
		super("Turn Right");
		this.gw = gw;
	}
	
	/**
	 * Calls the turnRight method in GameWorld
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.turnRight();
		//System.out.println("Turning Right");
		
	}

}
