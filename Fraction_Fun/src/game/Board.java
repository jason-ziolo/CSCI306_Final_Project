package game;

import java.util.LinkedList;

public class Board {
	private LinkedList<Player> players;
	private Player currentPlayer;
	private Fraction currentProblem;
	
	
	public void initialize(){
		
	}
	
	public void movePlayer(){
		
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public LinkedList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(LinkedList<Player> players) {
		this.players = players;
	}
}
