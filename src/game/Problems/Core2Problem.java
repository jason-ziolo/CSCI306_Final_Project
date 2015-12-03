package game.Problems;

import java.util.LinkedList;
import java.util.Random;

import game.Fraction;
import game.Player;
import game.Problem;
import game.ZeroDenomException;

@SuppressWarnings("serial")
public class Core2Problem extends Problem {

	public Core2Problem() throws ZeroDenomException {
		super();
		// Two fractions are randomly generated
		// They can have any relationship to each other
		// The player will guess a RelationOperator
		// the correct RelationOperator will be determined upon generating the problem
		Random rand = new Random();
		int den = rand.nextInt(12) + 1;
		int den2 = rand.nextInt(12) + 1;
		int num = rand.nextInt(den) + 1;
		int num2 = rand.nextInt(den2) + 1;
		Fraction first = new Fraction(num, den);
		Fraction second = new Fraction(num2, den2);
		fractions.add(first);
		fractions.add(second);
		// int 0 corresponds to less than
		// int 1 corresponds to equal to
		// int 2 corresponds to greater than
		if(first.equals(second)) {
			this.expectedAnswer = 1;
		}
		else if(first.getValue() < second.getValue()) {
			this.expectedAnswer = 0;
		} else {
			this.expectedAnswer = 2;
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(2).move();
	}

}
