package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class FlagCollisionCommand extends Command{
	
	private GameWorld gw;
	
	public FlagCollisionCommand(GameWorld gw) {
		super("Collide with flag");
		this.gw = gw;
	}
	
	/**
	 * Creates a dialog box asking which flag you are colliding with.
	 * It tries to pars an int if it cant it will repromt you for the flag number.
	 * If it is an int it checks to make sure it is between 1 and 9.
	 * if it is not it promts you again, if it is it calls the method hitflag from
	 * gw with the inputed int,
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		Command okCommand = new Command("Ok");
		TextField myTextField = new TextField();
		Command c = Dialog.show("Enter a flag number 1-9", myTextField, okCommand);
		
		int flagSequenceNumber = 1;
		if(c == okCommand) {
			try {
				flagSequenceNumber = Integer.parseInt(myTextField.getText());
			}
			catch(Exception ex) {
				Dialog.show("Error!", "Enter a flag number 1-9", "Ok", null);
				this.actionPerformed(ev);
				return;
			}
		}
		else {
			c = Dialog.show("Error! Enter a flag number 1-9", myTextField, okCommand);
		}
		
		if(flagSequenceNumber > 9 || flagSequenceNumber < 0) {
			Dialog.show("Error!", "Enter a flag number 1-9", "Ok", null);
			this.actionPerformed(ev);
			return;
		}
		
		gw.hitFlag(flagSequenceNumber);
	}

}
