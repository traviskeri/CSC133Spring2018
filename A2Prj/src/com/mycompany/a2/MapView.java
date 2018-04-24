package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.plaf.Border;


public class MapView extends Container implements Observer {
	
	//private ArrayList<Label> labels;
	private GameWorld gw;
	
	/**
	 * Constructor for MapView, you pass in the GameWorld it calls map and sets up a red border
	 * @param gw GameWorld
	 */
	public MapView(GameWorld gw) {
		this.gw =gw;
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(255,0,0)));
		
		
	}
	
	/**
	 * Update method for the observer. It calls map() in GameWorld.
	 */
	public void update(Observable observable, Object data) {
		System.out.println("updating");
		gw.map();
	}
	
	public void setMapViewSize() {
		System.out.println("Width: " + getWidth() + " Height: " + getHeight());
		gw.setMaxX(getHeight());
		gw.setMaxY(getWidth());
	}

}
