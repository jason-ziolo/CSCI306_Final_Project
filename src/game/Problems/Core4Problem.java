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
		MixedNumber mixed = new MixedNumber(num, den, scalar); // Not sure if this is what was meant
		//expectedAnswer = num*scalar;
		expectedAnswer = num + (den*scalar); // Also think this is what the expected answer should be
		
		this.setLayout(new GridLayout(0,4));
		JTextField blank1 = new JTextField("");
		blank1.setHorizontalAlignment(blank1.CENTER);
		blank1.setFont(new Font("Arial", 0, 25));
		blank1.setBorder(BorderFactory.createEmptyBorder());
		blank1.setEditable(false);
		
		JTextField numText = new JTextField(String.valueOf(mixed.getNumerator()));
		numText.setHorizontalAlignment(numText.CENTER);
		numText.setFont(new Font("Arial", 0, 25));
		numText.setBorder(BorderFactory.createEmptyBorder());
		numText.setEditable(false);
		
		JTextField blank2 = new JTextField("");
		blank2.setHorizontalAlignment(blank2.CENTER);
		blank2.setFont(new Font("Arial", 0, 25));
		blank2.setBorder(BorderFactory.createEmptyBorder());
		blank2.setEditable(false);
		
		blankAnswer = new JTextField("");
		blankAnswer.setHorizontalAlignment(blankAnswer.CENTER);
		blankAnswer.setFont(new Font("Arial", 0, 25));
		blankAnswer.setBorder(BorderFactory.createEmptyBorder());
		blankAnswer.setEditable(false);
		
		JTextField wholeNum = new JTextField(String.valueOf(mixed.getWholeNumber()));
		wholeNum.setHorizontalAlignment(wholeNum.CENTER);
		wholeNum.setFont(new Font("Arial", 0, 25));
		wholeNum.setBorder(BorderFactory.createEmptyBorder());
		wholeNum.setEditable(false);
		
		JTextField bar1 = new JTextField("____");
		bar1.setHorizontalAlignment(bar1.CENTER);
		bar1.setFont(new Font("Arial", 0, 25));
		bar1.setBorder(BorderFactory.createEmptyBorder());
		bar1.setEditable(false);
		
		JTextField equals = new JTextField("=");
		equals.setHorizontalAlignment(equals.CENTER);
		equals.setFont(new Font("Arial", 0, 25));
		equals.setBorder(BorderFactory.createEmptyBorder());
		equals.setEditable(false);
		
		JTextField bar2 = new JTextField("____");
		bar2.setHorizontalAlignment(bar2.CENTER);
		bar2.setFont(new Font("Arial", 0, 25));
		bar2.setBorder(BorderFactory.createEmptyBorder());
		bar2.setEditable(false);
		
		JTextField blank3 = new JTextField("");
		blank3.setHorizontalAlignment(blank3.CENTER);
		blank3.setFont(new Font("Arial", 0, 25));
		blank3.setBorder(BorderFactory.createEmptyBorder());
		blank3.setEditable(false);
		
		JTextField denText = new JTextField(String.valueOf(mixed.getDenominator()));
		denText.setHorizontalAlignment(denText.CENTER);
		denText.setFont(new Font("Arial", 0, 25));
		denText.setBorder(BorderFactory.createEmptyBorder());
		denText.setEditable(false);
		
		JTextField blank4 = new JTextField("");
		blank4.setHorizontalAlignment(blank2.CENTER);
		blank4.setFont(new Font("Arial", 0, 25));
		blank4.setBorder(BorderFactory.createEmptyBorder());
		blank4.setEditable(false);
		
		JTextField denAnswer = new JTextField(String.valueOf(den));
		denAnswer.setHorizontalAlignment(denAnswer.CENTER);
		denAnswer.setFont(new Font("Arial", 0, 25));
		denAnswer.setBorder(BorderFactory.createEmptyBorder());
		denAnswer.setEditable(false);
		
		this.add(blank1);
		this.add(numText);
		this.add(blank2);
		this.add(blankAnswer);
		
		this.add(wholeNum);
		this.add(bar1);
		this.add(equals);
		this.add(bar2);
		
		this.add(blank3);
		this.add(denText);
		this.add(blank4);
		this.add(denAnswer);
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(3).move();
	}
}
