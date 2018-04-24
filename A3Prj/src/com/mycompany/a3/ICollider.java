package com.mycompany.a3;

public interface ICollider {
	
	public boolean collidesWith(ICollider cObj);
	public void handleCollision(ICollider cObj);
}
