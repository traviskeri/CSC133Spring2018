package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command {
	
	private GameWorld gw;

	public SoundCommand(GameWorld gw) {
		super("Sound ON/OFF");
		this.gw = gw;
	}
	
	/**
	 * Changes isSound in GameWorld
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(gw.isSound()) {
			gw.setSound(false);
		}
		else {
			gw.setSound(true);
		}
	}
}
