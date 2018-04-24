package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

public class ScoreView extends Container implements Observer{
	
	private GameWorld gw;
	Label livesValue;
	Label clockValue;
	Label flagValue;
	Label foodValue;
	Label healthValue;
	Label soundValue;
	
	/**
	 * Constructor for ScoreView. It takes in the GameWorld and creates labels for the lives, clock,
	 * last flag reached, food level, health, and sound and adding them to the north container
	 * @param gw GameWorld
	 */
	public ScoreView(GameWorld gw) {
		this.gw =gw;
		this.setLayout(new FlowLayout(Component.CENTER));
		Label livesTitle = new Label("Lives left: ");
		livesValue = new Label("" + gw.getLives());
		Label clockTitle = new Label("Clock: ");
		clockValue = new Label("     " + gw.getClock());
		Label flagTitle = new Label("Last Flag: ");
		flagValue = new Label("1" );
		Label foodTitle = new Label("Food left: ");
		foodValue = new Label("10    " );
		Label healthTitle = new Label("Health: ");
		healthValue = new Label("10" );
		Label soundTitle = new Label("Sound: ");
		soundValue = new Label("ON  ");
		
		this.add(livesTitle);
		this.add(livesValue);
		this.add(clockTitle);
		this.add(clockValue);
		this.add(flagTitle);
		this.add(flagValue);
		this.add(foodTitle);
		this.add(foodValue);
		this.add(healthTitle);
		this.add(healthValue);
		this.add(soundTitle);
		this.add(soundValue);
		
	}

	/**
	 * Update command for the observers. It updates the values for lives, clock, last flag reached, food level, health,
	 * and sound
	 */
	public void update(Observable observable, Object data) {
		livesValue.setText("" + gw.getLives());
		clockValue.setText("" + gw.getClock());
		flagValue.setText("" + gw.getLastFlagReached());
		foodValue.setText("" + gw.getLBFood());
		healthValue.setText("" + gw.getLBHealth());
		
		if(gw.isSound()) {
			soundValue.setText("OFF");
		}
		else {
			soundValue.setText("ON  ");
		}
				
	}

}
