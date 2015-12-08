package game.Problems;

import java.awt.GridLayout;
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
		Fraction result = new Fraction(num2 + 10*num, den2);
		this.expectedAnswer = result.getNumerator();
		
		this.setLayout(new GridLayout(0, 5));
		this.makeField(String.valueOf(num));
		this.makeField("");
		this.makeField(String.valueOf(num2));
		this.makeField("");
		blankAnswer = this.makeAnswer();
		this.makeField("____");
		this.makeField("+");
		this.makeField("____");
		this.makeField("=");
		this.makeField("____");
		this.makeField(String.valueOf(den));
		this.makeField("");
		this.makeField(String.valueOf(den2));
		this.makeField("");
		this.makeField(String.valueOf(result.getDenominator()));
		
		this.setVisible(true);
		this.setSize(50, 50);
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(1).move();
	}
}
