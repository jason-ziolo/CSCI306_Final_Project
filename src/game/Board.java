package game;

import java.util.LinkedList;

public class Board {
	private LinkedList<Player> players;
	private Fraction currentProblem;
	private boolean answerRight;
	
	public Board(){
		
	}
	
	public void initialize(){
		
	}
	
	public void movePlayer(){
		
	}
	
	public boolean checkAnswer(){
		return false;
	}

	public LinkedList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(LinkedList<Player> players) {
		this.players = players;
	}

	public boolean isAnswerRight() {
		return answerRight;
	}

	public void setAnswerRight(boolean answerRight) {
		this.answerRight = answerRight;
	}

	public Fraction getCurrentProblem() {
		return currentProblem;
	}

	public void setCurrentProblem(Fraction currentProblem) {
		this.currentProblem = currentProblem;
	}
}
