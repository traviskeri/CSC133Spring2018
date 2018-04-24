package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command {
	
	private GameWorld gw;
	
	public ExitCommand(GameWorld gw) {
		super("Exit");
		this.gw = gw;
	}
	
	/**
	 * Creates a dialog box to ask if you want to quit with two 
	 * options yes and no
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		Command yesCommand = new Command("Yes");
		Command noCommand = new Command("No");
		Label myLabel = new Label("");
		
		Command c = Dialog.show("Are you sure you want to exit?", myLabel, yesCommand, noCommand);
		
		if(c == yesCommand) {
			gw.exit();
		}
		else if(c == noCommand) {
			return;
		}
		
		
	}

}
