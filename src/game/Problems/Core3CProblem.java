package game.Problems;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import game.Fraction;
import game.MixedNumber;
import game.Player;
import game.Problem;
import game.ZeroDenomException;

@SuppressWarnings("serial")
public class Core3CProblem extends Problem {
	
	public Core3CProblem() throws ZeroDenomException {
		super();
		Random rand = new Random();
		int whole = rand.nextInt(4) + 1;
		int den = rand.nextInt(12) + 1;
		int num = rand.nextInt(den) + 1;
		MixedNumber mixed = new MixedNumber(num, den, whole);
		Fraction fraction = mixed.toFraction();
		expectedAnswer = fraction.getNumerator();

		this.setVisible(true);
		this.setSize(50, 50);
		
		this.setLayout(new GridLayout(0,4));
		this.makeField("");
		this.makeField(String.valueOf(num));
		this.makeField("");
		blankAnswer = this.makeAnswer();
		this.makeField(String.valueOf(mixed.getWholeNumber()));
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
		players.get(2).move();
	}
}
