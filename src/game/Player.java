package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int location;
	protected Color color;
	private int myId;
	public static int id = 0;
	
	public Player(){
		location = 0;
		myId = id;
		id++;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(location * Board.distance , myId * Board.distance, Board.distance * 4/5, Board.distance * 4/5);
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
	
	public int getID(){
		return myId;
	}
}
