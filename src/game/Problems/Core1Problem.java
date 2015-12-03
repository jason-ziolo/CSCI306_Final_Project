package game.Problems;

import java.util.LinkedList;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import game.Fraction;
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
		fractions.add(new Fraction(num, den));
		fractions.add(new Fraction(num*scalar, den*scalar));
		expectedAnswer = num*scalar;
		
		this.setVisible(true);
		this.setSize(50, 50);
		this.add(new JTextField("Hello"));
		this.setBorder(new TitledBorder(new EtchedBorder(), "hi"));
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(1).move();
	}
}
