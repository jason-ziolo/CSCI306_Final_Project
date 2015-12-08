package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel{
	private static LinkedList<Player> players;
	private Problem currentProblem;
	public static final int MAX_SIZE = 6; // There are six problem types in total
	public static int distance;
	public boolean answerRight;
	
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
		if (currentProblem.isCorrect()){
			players.getFirst().move();
		} else {
			currentProblem.advanceComputer(players);
		}
		repaint();
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

	public static LinkedList<Player> getPlayers() {
		return players;
	}

	public boolean isAnswerRight() {
		return answerRight;
	}

	public void setAnswerRight(boolean answerRight) {
		this.answerRight = answerRight;
	}
	
	public void setPlayers(LinkedList<Player> players) {
		Board.players = players;
	}

	public Problem getCurrentProblem() {
		return currentProblem;
	}

	public void setCurrentProblem(Problem currentProblem) {
		this.currentProblem = currentProblem;
	}
}
