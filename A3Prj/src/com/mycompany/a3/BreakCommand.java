package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class BreakCommand extends Command{
	
	private GameWorld gw;

	public BreakCommand(GameWorld gw) {
		super("Break");
		this.gw = gw;
	}
	
	/**
	 * Calls the slowDown method in Gameworld
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.slowDown();
		//System.out.println("Slowing Down");
		
	}
}
