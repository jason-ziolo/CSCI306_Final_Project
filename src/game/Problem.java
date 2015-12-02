package game;

import java.util.LinkedList;

/**
 * Problem class:
 * Abstract, parent of Core1Problem, Core2Problem, Core3BProblem, Core3CProblem, Core4Problem, Core5Problem
 * Contains abstract functions: void draw(), boolean isCorrect()
 * Contains empty constructor
 */
public abstract class Problem {
	protected LinkedList<Fraction> fractions = new LinkedList<Fraction>();
	protected int answer = -1; // this will never be -1 for an actual problem
	protected int expectedAnswer;
	
	public Problem() {
	}
	
	public abstract void draw();

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
