package game;

import java.awt.Color;
import java.util.Random;

public class ComputerPlayer extends Player {

	public ComputerPlayer(){
		Random rand = new Random();
		int red = rand.nextInt(256);
		int blue = rand.nextInt(256);
		int green = rand.nextInt(256);
		color = new Color(red, green, blue);
	}
}
