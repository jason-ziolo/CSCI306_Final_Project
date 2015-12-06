package game.Problems;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import game.Fraction;
import game.Player;
import game.Problem;
import game.ProblemDisplay;
import game.ZeroDenomException;
import javafx.scene.shape.Line;

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
		
		this.setLayout(new GridLayout(0, 3));
		
		JTextField numText = new JTextField(String.valueOf(num));
		numText.setHorizontalAlignment(numText.CENTER);
		numText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		numText.setFont(new Font("Arial", 0, 25));
		numText.setEditable(false);
		
		JTextField blank1 = new JTextField("");
		blank1.setHorizontalAlignment(blank1.CENTER);
		blank1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		blank1.setFont(new Font("Arial", 0, 25));
		blank1.setEditable(false);
		
		blankAnswer = new JTextField("");
		blankAnswer.setHorizontalAlignment(blankAnswer.CENTER);
		blankAnswer.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		blankAnswer.setFont(new Font("Arial", 0, 25));
		blankAnswer.setEditable(false);
		
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
		
		JTextField denText = new JTextField(String.valueOf(den));
		denText.setHorizontalAlignment(denText.CENTER);
		denText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		denText.setFont(new Font("Arial", 0, 25));
		denText.setEditable(false);
		
		JTextField blank2 = new JTextField("");
		blank2.setHorizontalAlignment(blank2.CENTER);
		blank2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		blank2.setFont(new Font("Arial", 0, 25));
		blank2.setEditable(false);
		
		JTextField den2Text = new JTextField(String.valueOf(den*scalar));
		den2Text.setHorizontalAlignment(den2Text.CENTER);
		den2Text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		den2Text.setFont(new Font("Arial", 0, 25));
		den2Text.setEditable(false);
		
		this.add(numText);
		this.add(blank1);
		this.add(blankAnswer);
		this.add(bar1);
		this.add(equalSign);
		this.add(bar2);
		this.add(denText);
		this.add(blank2);
		this.add(den2Text);
		//this.setBorder(new TitledBorder(new EtchedBorder(), "Core 1 Problem"));
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(1).move();
	}
}
