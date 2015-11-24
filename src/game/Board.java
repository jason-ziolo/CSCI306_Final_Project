package game;

import java.util.LinkedList;

public class Board {
	private LinkedList<Player> players;
	private Problem currentProblem;
	private boolean answerRight;
	public final int MAX_SIZE = 5;
	
	public Board(){
		
	}
	
	public void initialize(){
		
	}
	
	public void movePlayer(){
		
	}
	
	public boolean checkOver(){
		return false;
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

	public Problem getCurrentProblem() {
		return currentProblem;
	}

	public void setCurrentProblem(Problem currentProblem) {
		this.currentProblem = currentProblem;
	}
}
