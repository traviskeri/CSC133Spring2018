package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
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
		//System.out.println("updating");
		//gw.map();
	}
	
	public void setMapViewSize() {
		gw.setMaxX(getComponentForm().getWidth()-(2*getX()));
		gw.setMaxY(getComponentForm().getHeight()-(getAbsoluteY()+getY()));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(getX(), getY());
		gw.draw(g, pCmpRelPrnt);
	}

}
