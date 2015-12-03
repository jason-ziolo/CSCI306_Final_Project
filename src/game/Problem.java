package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * Problem class:
 * Abstract, parent of Core1Problem, Core2Problem, Core3BProblem, Core3CProblem, Core4Problem, Core5Problem
 * Contains abstract functions: void draw(), boolean isCorrect()
 * Contains empty constructor
 */

@SuppressWarnings("serial")
public abstract class Problem extends JPanel{
	protected LinkedList<Fraction> fractions = new LinkedList<Fraction>();
	protected int answer = -1; // this will never be -1 for an actual problem
	protected int expectedAnswer;
	
	public Problem() {
	}
	
	public abstract void advanceComputer(LinkedList<Player> players);

	public boolean isCorrect() {
		if(answer == expectedAnswer)
			return true;
		return false;
	}
	
	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getExpectedAnswer() {
		return expectedAnswer;
	}
}
