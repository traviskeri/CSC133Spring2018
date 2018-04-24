package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.UITimer;

public class PauseCommand extends Command{
	
	private GameWorld gw;
	
	public PauseCommand(GameWorld gw) {
		super("Pause");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.setPauseEnabled(true);
		gw.setPaused(!gw.isPaused());
		gw.setPosEnabled(false);
		System.out.println("Paused");
		
	}

}
