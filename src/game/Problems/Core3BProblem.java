package game.Problems;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

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
		
		this.setLayout(new GridLayout(0, 5));
		JTextField numText = new JTextField(String.valueOf(LHS.getNumerator()));
		numText.setHorizontalAlignment(numText.CENTER);
		numText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		numText.setFont(new Font("Arial", 0, 25));
		numText.setEditable(false);
		JTextField blank1 = new JTextField("");
		blank1.setHorizontalAlignment(blank1.CENTER);
		blank1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		blank1.setFont(new Font("Arial", 0, 25));
		blank1.setEditable(false);
		JTextField num2Text = new JTextField(String.valueOf(RHS.getNumerator()));
		num2Text.setHorizontalAlignment(num2Text.CENTER);
		num2Text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		num2Text.setFont(new Font("Arial", 0, 25));
		num2Text.setEditable(false);
		JTextField blank2 = new JTextField("");
		blank2.setHorizontalAlignment(blank2.CENTER);
		blank2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		blank2.setFont(new Font("Arial", 0, 25));
		blank2.setEditable(false);
		JTextField blankNumerator = new JTextField("");
		blankNumerator.setHorizontalAlignment(blankNumerator.CENTER);
		blankNumerator.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		blankNumerator.setFont(new Font("Arial", 0, 25));
		blankNumerator.setEditable(false);
		JTextField bar1 = new JTextField("____");
		bar1.setHorizontalAlignment(bar1.CENTER);
		bar1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bar1.setFont(new Font("Arial", 0, 25));
		bar1.setEditable(false);
		JTextField equalSign = new JTextField("=");
		equalSign.setHorizontalAlignment(equalSign.CENTER);
		equalSign.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		equalSign.setFont(new Font("Arial", 0, 25));
		equalSign.setEditable(false);
		JTextField bar2 = new JTextField("____");
		bar2.setHorizontalAlignment(bar2.CENTER);
		bar2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bar2.setFont(new Font("Arial", 0, 25));
		bar2.setEditable(false);
		JTextField plusSign = new JTextField("+");
		plusSign.setHorizontalAlignment(plusSign.CENTER);
		plusSign.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		plusSign.setFont(new Font("Arial", 0, 25));
		plusSign.setEditable(false);
		JTextField bar3 = new JTextField("____");
		bar3.setHorizontalAlignment(bar3.CENTER);
		bar3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bar3.setFont(new Font("Arial", 0, 25));
		bar3.setEditable(false);
		JTextField denText = new JTextField(String.valueOf(LHS.getDenominator()));
		denText.setHorizontalAlignment(denText.CENTER);
		denText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		denText.setFont(new Font("Arial", 0, 25));
		denText.setEditable(false);
		JTextField blank3 = new JTextField("");
		blank3.setHorizontalAlignment(blank3.CENTER);
		blank3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		blank3.setFont(new Font("Arial", 0, 25));
		blank3.setEditable(false);
		JTextField den2Text = new JTextField(String.valueOf(RHS.getDenominator()));
		den2Text.setHorizontalAlignment(den2Text.CENTER);
		den2Text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		den2Text.setFont(new Font("Arial", 0, 25));
		den2Text.setEditable(false);
		JTextField blank4 = new JTextField("");
		blank4.setHorizontalAlignment(blank4.CENTER);
		blank4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		blank4.setFont(new Font("Arial", 0, 25));
		blank4.setEditable(false);
		JTextField den3Text = new JTextField(String.valueOf(LHS.getDenominator()));
		den3Text.setHorizontalAlignment(den3Text.CENTER);
		den3Text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		den3Text.setFont(new Font("Arial", 0, 25));
		den3Text.setEditable(false);
		
		this.add(numText);
		this.add(blank1);
		this.add(num2Text);
		this.add(blank2);
		this.add(blankNumerator);
		this.add(bar1);
		this.add(equalSign);
		this.add(bar2);
		this.add(plusSign);
		this.add(bar3);
		this.add(denText);
		this.add(blank3);
		this.add(den2Text);
		this.add(blank4);
		this.add(den3Text);
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(3).move();
	}
}
