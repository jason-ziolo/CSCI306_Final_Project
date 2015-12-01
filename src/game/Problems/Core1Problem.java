package game.Problems;

import java.util.LinkedList;
import java.util.Random;

import game.Fraction;
import game.Player;
import game.Problem;
import game.ZeroDenomException;

public class Core1Problem extends Problem {
	
	private int answer;
	private int expectedAnswer;
	
	public Core1Problem() throws ZeroDenomException {
		super();
		Random rand = new Random();
		int num = rand.nextInt(12) + 1;
		int den = rand.nextInt(12) + 1;
		int scalar = rand.nextInt(4) + 1;
		fractions.add(new Fraction(num, den));
		fractions.add(new Fraction(num*scalar, den*scalar));
		expectedAnswer = num*scalar;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean isCorrect() {
		if(answer == expectedAnswer)
			return true;
		return false;
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(1).move();
	}
	
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	// For testing only
	public int getExpectedAnswer() {
		return expectedAnswer;
	}

}
