package game.Problems;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JComboBox;

import game.Fraction;
import game.Player;
import game.Problem;
import game.ZeroDenomException;

@SuppressWarnings("serial")
public class Core2Problem extends Problem {
	public JComboBox<String> equality;
	
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
		this.makeField(String.valueOf(num));
		this.makeField("");
		this.makeField(String.valueOf(num2));
		this.makeField("____");
		equality = new JComboBox<String>();
		equality.addItem("<");
		equality.addItem("=");
		equality.addItem(">");
		equality.addItemListener(new DropdownListener());
		equality.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		equality.setFont(new Font("Arial", 0, 25));
		this.add(equality);
		this.makeField("____");
		this.makeField(String.valueOf(den));
		this.makeField("");
		this.makeField(String.valueOf(den2));
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
	
	@Override
	public String getExpectedAnswerStr(){
		if (expectedAnswer == 0){
			return "less than";
		} else if (expectedAnswer == 1){
			return "equal to";
		} else { 
			return "greater than";
		}
	}
}
