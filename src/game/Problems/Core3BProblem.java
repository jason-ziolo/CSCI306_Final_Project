package game.Problems;

import java.util.LinkedList;
import java.util.Random;

import game.Fraction;
import game.Player;
import game.Problem;
import game.ZeroDenomException;

@SuppressWarnings("serial")
public class Core3BProblem extends Problem {

	public Core3BProblem() throws ZeroDenomException {
		super();
		// One denominator for three fractions
		// Two numerators are generated,
		// the larger of the two is used for
		// the LHS, the smaller is used for the RHS
		// where the third numerator is added to the
		// RHS numerator to get the LHS numerator
		Random rand = new Random();
		int den = rand.nextInt(12) + 1;
		int num = rand.nextInt(den) + 1;
		int num2 = 0;
		do {
			num2 = rand.nextInt(12) + 1;
		} while(num2 == num);
		Fraction LHS, RHS;
		if(num2 > num) {
			LHS = new Fraction(num2, den);
			RHS = new Fraction(num, den);
		} else {
			LHS = new Fraction(num, den);
			RHS = new Fraction(num2, den);
		}
		this.expectedAnswer = Math.abs(num2 - num);
		fractions.add(LHS);
		fractions.add(RHS);
		fractions.add(new Fraction(this.expectedAnswer, den)); // will add answer, but it will not be shown (only denominator)
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(3).move();
	}

}
