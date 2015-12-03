package game.Problems;

import java.util.LinkedList;
import java.util.Random;

import game.Fraction;
import game.MixedNumber;
import game.Player;
import game.Problem;
import game.ZeroDenomException;

@SuppressWarnings("serial")
public class Core3CProblem extends Problem {

	private boolean mixedToFrac;
	
	public Core3CProblem() throws ZeroDenomException {
		super();
		Random rand = new Random();
		int whole = rand.nextInt(4) + 1;
		int den = rand.nextInt(12) + 1;
		int num = rand.nextInt(den) + 1;
		MixedNumber mixed = new MixedNumber(num, den, whole);
		fractions.add(mixed);
		Fraction fraction = mixed.getFraction();
		fractions.add(fraction);
		mixedToFrac = rand.nextBoolean();
		if(mixedToFrac) {
			this.expectedAnswer = fraction.getNumerator();
		} else {
			this.expectedAnswer = mixed.getWholeNumber();
		}
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(2).move();
	}

}
