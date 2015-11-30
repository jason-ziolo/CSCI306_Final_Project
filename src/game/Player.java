package game;

import java.awt.Color;

public class Player {
	private int location;
	private Color color;
	
	public Player(){
		location = 0;
		color = Color.red;
	}
	
	public void draw(){
		
	}
	
	public void move(){
		location++;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
}
