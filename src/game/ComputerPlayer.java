package game;

import java.awt.Color;

public class ComputerPlayer extends Player {

	public ComputerPlayer(Color color){
		/*Random rand = new Random();
		int red = rand.nextInt(256);
		int blue = rand.nextInt(256);
		int green = rand.nextInt(256);
		color = new Color(red, green, blue);*/
		this.color = color;
	}
}
