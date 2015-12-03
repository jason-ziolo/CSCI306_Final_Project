package game.Problems;

import java.util.LinkedList;
import java.util.Random;

import game.Fraction;
import game.Player;
import game.Problem;
import game.ZeroDenomException;

@SuppressWarnings("serial")
public class Core4Problem extends Problem {

	private int scalar;
	
	public Core4Problem() throws ZeroDenomException {
		super();
		Random rand = new Random();
		int den = rand.nextInt(12) + 1;
		int num = rand.nextInt(den) + 1;
		scalar = rand.nextInt(5) + 1; // scalar is saved, so it may be drawn later
		fractions.add(new Fraction(num, den));
		fractions.add(new Fraction(num*scalar, den));
		expectedAnswer = num*scalar;
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(3).move();
	}

}
