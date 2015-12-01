package game.Problems;

import java.util.LinkedList;

import game.Player;
import game.Problem;

public class Core4Problem extends Problem {

	public Core4Problem() {
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
		players.get(3).move();
	}

}
