package game.Problems;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;
import game.Player;
import game.Problem;
import game.ZeroDenomException;

@SuppressWarnings("serial")
public class Core1Problem extends Problem {
	
	public Core1Problem() throws ZeroDenomException {
		super();
		
		Random rand = new Random();
		int den = rand.nextInt(12) + 1;
		int num = rand.nextInt(den) + 1;
		int scalar = rand.nextInt(4) + 1;
		expectedAnswer = num*scalar;
		
		this.setLayout(new GridLayout(0, 3));
		
		this.makeField(String.valueOf(num));
		this.makeField("");
		
		blankAnswer = this.makeAnswer();
		
		this.makeField("____");
		this.makeField("=");
		this.makeField("____");
		this.makeField(String.valueOf(den));
		this.makeField("");
		this.makeField(String.valueOf(den*scalar));
		//this.setBorder(new TitledBorder(new EtchedBorder(), "Core 1 Problem"));
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(1).move();
	}
}
