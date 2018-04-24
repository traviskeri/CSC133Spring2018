package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SpiderCollisionCommand extends Command {
	
	private GameWorld gw;
	
	public SpiderCollisionCommand(GameWorld gw) {
		super("Collide with spider");
		this.gw = gw;
	}
	
	/**
	 * Calls the hitSpider method in GameWorld
	 * and checks for game over
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.hitSpider();
		System.out.println("hit spider");
		gw.checkGameOver();
		
	}

}
