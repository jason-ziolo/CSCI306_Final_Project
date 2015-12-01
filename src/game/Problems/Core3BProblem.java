package game.Problems;

import java.util.LinkedList;

import game.Player;
import game.Problem;

public class Core3BProblem extends Problem {

	public Core3BProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCorrect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void advanceComputer(LinkedList<Player> players) {
		players.get(2).move();
	}

}
