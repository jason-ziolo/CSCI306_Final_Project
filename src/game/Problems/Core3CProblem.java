package game.Problems;

import java.util.LinkedList;
import java.util.Random;

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
		
		this.setVisible(true);
		this.setSize(50, 50);
		this.add(new JTextField("Problem 3C"));
		this.setBorder(new TitledBorder(new EtchedBorder(), "Core 3C Problem"));
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(2).move();
	}
}
