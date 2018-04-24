package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {
	
	public AboutCommand() {
		super("About");
	}
	
	/**
	 * Creates a DialogBox displaying the info about the game
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		Command okCommand = new Command("Ok");
		TextArea aboutText = new TextArea("Author: Travis Keri Course: CSC 133 Version: 2", 3, 12);
		aboutText.setEditable(false);
		//Label aboutLabel = new Label("Author: Travis Keri. Course: CSC 133. Version: 2");
		
		Command c = Dialog.show("About", aboutText, okCommand);
		
		if(c == okCommand) {
			return;
		}
		
	}

}
