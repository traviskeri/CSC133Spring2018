package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.table.TableLayout;

public class HelpCommand extends Command {
	
	
	public HelpCommand() {
		super("Help");
	}

	/**
	 * Creates a dialog box to display how to play the game
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		Command okCommand = new Command("Ok");
		Dialog d = new Dialog("Help", new TableLayout(10,3));
		d.add(new Label("Command"));
		d.add(new Label("Action"));
		d.add(new Label("Key Binding"));
		d.add(new Label("Accelerate"));
		d.add(new Label("Speed up the Ladybug"));
		d.add(new Label("a"));
		d.add(new Label("Break"));
		d.add(new Label("Slow down the Ladybug"));
		d.add(new Label("b"));
		d.add(new Label("Left Turn"));
		d.add(new Label("Turn the Ladybug Left"));
		d.add(new Label("l"));
		d.add(new Label("Right Turn"));
		d.add(new Label("Turn the Ladybug Right"));
		d.add(new Label("r"));
		d.add(new Label("Collide with Flag"));
		d.add(new Label("Increase Last Flag Reached"));
		d.add(new Label("none"));
		d.add(new Label("Collide with Food Station"));
		d.add(new Label("Increase Food Level"));
		d.add(new Label("f"));
		d.add(new Label("Collide with spider"));
		d.add(new Label("Lower Health Level"));
		d.add(new Label("g"));
		d.add(new Label("Clock Tick"));
		d.add(new Label("Move Ladybugs and spiders"));
		d.add(new Label("t"));
		d.add(new Label("Exit"));
		d.add(new Label("Exit the Game"));
		d.add(new Label("x"));
		
		Command c = Dialog.show("", d , okCommand);
		if(c == okCommand) {
			return;
		}
		
		
	}
}
