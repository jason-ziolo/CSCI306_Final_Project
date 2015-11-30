package game;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Board extends JPanel{
	private LinkedList<Player> players;
	private Problem currentProblem;
	private boolean answerRight;
	public final int MAX_SIZE = 5;
	
	public Board(){
		players = new LinkedList<Player>();
	}
	
	public void initialize(){
		HumanPlayer humanPlayer = new HumanPlayer();
		ComputerPlayer CPU1 = new ComputerPlayer();
		ComputerPlayer CPU2 = new ComputerPlayer();
		ComputerPlayer CPU3 = new ComputerPlayer();
		players.add(humanPlayer);
		players.add(CPU1);
		players.add(CPU2);
		players.add(CPU3);
	}
	
	public void movePlayer(){
		if (answerRight){
			players.get(0).move();
		} else if (currentProblem.getType() == ProblemType.Core1 || currentProblem.getType() == ProblemType.Core5){
			players.get(1).move();
		} else if (currentProblem.getType() == ProblemType.Core2 || currentProblem.getType() == ProblemType.Core3c){
			players.get(2).move();
		} else{
			players.get(3).move();
		}
	}
	
	public boolean checkOver(){
		for (Player player : players){
			if (player.getLocation() == (MAX_SIZE))
				return true;
		}
		return false;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
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
