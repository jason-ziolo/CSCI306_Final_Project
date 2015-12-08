package game.Problems;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;

import game.Player;
import game.Problem;
import game.ZeroDenomException;

@SuppressWarnings("serial")
public class Core4Problem extends Problem {
	
	public Core4Problem() throws ZeroDenomException {
		/* 
		 * For clarification: this problem does NOT involve a whole number at all
		 * This problem tests the scalar multiplication of a fraction.
		 */
		super();
		Random rand = new Random();
		int den = rand.nextInt(12) + 1;
		int num = rand.nextInt(den) + 1;
		int scalar = rand.nextInt(5) + 1; // scalar is saved, so it may be drawn later
		expectedAnswer = num*scalar;
		//expectedAnswer = num + (den*scalar); // Also think this is what the expected answer should be
		
		this.setLayout(new GridLayout(0,4));
		this.makeField("");
		this.makeField(String.valueOf(num));
		this.makeField("");
		blankAnswer = this.makeAnswer();
		this.makeField(String.valueOf(scalar) + " *");
		this.makeField("____");
		this.makeField("=");
		this.makeField("____");
		this.makeField("");
		this.makeField(String.valueOf(den));
		this.makeField("");
		this.makeField(String.valueOf(den));
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(3).move();
	}
}
