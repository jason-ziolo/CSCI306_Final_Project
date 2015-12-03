package game.Problems;

import java.util.LinkedList;
import java.util.Random;

import game.Fraction;
import game.Player;
import game.Problem;
import game.ZeroDenomException;

@SuppressWarnings("serial")
public class Core5Problem extends Problem {

	public Core5Problem() throws ZeroDenomException {
		super();
		Random rand = new Random();
		int den = 10;
		int num = rand.nextInt(den) + 1;
		int den2 = 100;
		int num2 = rand.nextInt(den2) + 1;
		Fraction base10 = new Fraction(num, den);
		Fraction base100 = new Fraction(num2, den2);
		Fraction result = new Fraction(num2 + 10*num, den2);
		this.expectedAnswer = result.getNumerator();
		fractions.add(base10);
		fractions.add(base100);
		fractions.add(result); // will add answer, but it will not be shown (only denominator)
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(1).move();
	}

}
