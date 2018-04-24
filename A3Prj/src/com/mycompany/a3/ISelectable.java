package com.mycompany.a3;

import com.codename1.charts.models.Point;

public interface ISelectable {
	public void setSelected(boolean s);
	public boolean isSelected();
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt);
	
}
