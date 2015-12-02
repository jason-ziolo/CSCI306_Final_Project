package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel{
	private static LinkedList<Player> players;
	private Problem currentProblem;
	private boolean answerRight;
	public static final int MAX_SIZE = 5;
	public static int distance;
	
	public Board(){
		players = new LinkedList<Player>();
		initialize();
	}
	
	public void initialize(){
		HumanPlayer humanPlayer = new HumanPlayer();
		ComputerPlayer CPU1 = new ComputerPlayer(Color.BLUE);
		ComputerPlayer CPU2 = new ComputerPlayer(Color.GREEN);
		ComputerPlayer CPU3 = new ComputerPlayer(Color.MAGENTA);
		players.add(humanPlayer);
		players.add(CPU1);
		players.add(CPU2);
		players.add(CPU3);
		distance = Game.SIZE / MAX_SIZE;
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
		for (Player player : players){
			player.draw(g);
		}
		g.setColor(Color.BLACK);
		for (int i = 0; i < MAX_SIZE + 1; i++){
			for (int j = 0; j < players.size(); j++){
				g.drawOval(i * distance ,j * distance, distance * 4 / 5, distance * 4 / 5);
			}
		}
	}
	
	public boolean checkAnswer(){
		//TODO
		return false;
	}

	public static LinkedList<Player> getPlayers() {
		return players;
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
