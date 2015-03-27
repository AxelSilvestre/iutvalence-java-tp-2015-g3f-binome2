package fr.sedara.Pusher;

import java.io.Serializable;

public class Position implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1810013978124484773L;
	private final int x;
	private final int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
