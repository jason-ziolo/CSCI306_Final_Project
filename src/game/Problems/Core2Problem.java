package game.Problems;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import game.Fraction;
import game.Game;
import game.KeypadButton;
import game.Player;
import game.Problem;
import game.ZeroDenomException;

@SuppressWarnings("serial")
public class Core2Problem extends Problem {
	public JComboBox equality;
	
	public Core2Problem() throws ZeroDenomException {
		super();
		
		involvesKeypad = false;
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
		
		this.setLayout(new GridLayout(0, 3));
		JTextField numText = new JTextField(String.valueOf(num));
		numText.setHorizontalAlignment(numText.CENTER);
		numText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		numText.setFont(new Font("Arial", 0, 25));
		numText.setEditable(false);
		JTextField blank1 = new JTextField("");
		blank1.setHorizontalAlignment(numText.CENTER);
		blank1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		blank1.setFont(new Font("Arial", 0, 25));
		blank1.setEditable(false);
		JTextField num2Text = new JTextField(String.valueOf(num2));
		num2Text.setHorizontalAlignment(numText.CENTER);
		num2Text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		num2Text.setFont(new Font("Arial", 0, 25));
		num2Text.setEditable(false);
		JTextField bar1 = new JTextField("____");
		bar1.setHorizontalAlignment(numText.CENTER);
		bar1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bar1.setFont(new Font("Arial", 0, 25));
		bar1.setEditable(false);
		equality = new JComboBox();
		equality.addItem("<");
		equality.addItem("=");
		equality.addItem(">");
		equality.addItemListener(new DropdownListener());
		equality.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		equality.setFont(new Font("Arial", 0, 25));
		JTextField bar2 = new JTextField("____");
		bar2.setHorizontalAlignment(numText.CENTER);
		bar2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bar2.setFont(new Font("Arial", 0, 25));
		bar2.setEditable(false);
		JTextField denText = new JTextField(String.valueOf(den));
		denText.setHorizontalAlignment(numText.CENTER);
		denText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		denText.setFont(new Font("Arial", 0, 25));
		denText.setEditable(false);
		JTextField blank2 = new JTextField("");
		blank2.setHorizontalAlignment(numText.CENTER);
		blank2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		blank2.setFont(new Font("Arial", 0, 25));
		blank2.setEditable(false);
		JTextField den2Text = new JTextField(String.valueOf(den2));
		den2Text.setHorizontalAlignment(numText.CENTER);
		den2Text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		den2Text.setFont(new Font("Arial", 0, 25));
		den2Text.setEditable(false);
		
		this.add(numText);
		this.add(blank1);
		this.add(num2Text);
		this.add(bar1);
		this.add(equality);
		this.add(bar2);
		this.add(denText);
		this.add(blank2);
		this.add(den2Text);
	}

	public class DropdownListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			String test = (String) e.getItem();
			switch(test) {
			case "<": 
				setAnswer(0);
				break;
			case "=":
				setAnswer(1);
				break;
			case ">":
				setAnswer(2);
			}
		}
	}
	
	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(2).move();
	}
}
