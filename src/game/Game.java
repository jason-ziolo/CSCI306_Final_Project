package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Game extends JFrame{
	private static Board board;
	private static DisplayPanel display;
	public static final int SIZE = 500;
	public static final int PADDING = 100;
	private static LinkedList<ProblemType> problemType;	//This is here to avoid a lot of if statements down the line
	
	public Game(){
		this.setJMenuBar(mainJMenuBar());
		setName("Fraction Fun!");
		setTitle("Fraction Fun!");
		setSize(SIZE + PADDING, SIZE + PADDING);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addCores();
	}
	
	public static void main(String[] args){
		board = new Board();
		display = new DisplayPanel();
		Game game = new Game();
		game.add(board, BorderLayout.CENTER);
		game.add(display, BorderLayout.SOUTH);
		game.setVisible(true);
		
		while(!board.checkOver()){
			//game.playGame();
			board.repaint();
		}
		
		String message;
		if (Board.getPlayers().get(0).getLocation() == (Board.MAX_SIZE)){
			message = "You win the game!";
		} else {
			message = "The computer wins. You have want to brush up on the following Cores: TODO";
		}
		JOptionPane.showMessageDialog(null, message);
		System.exit(1);
	}
	
	
	
	private JMenuBar mainJMenuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		bar.add(menu);
		return bar;
	}
	
	private JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}
	
	private void addCores(){
		problemType = new LinkedList<ProblemType>();
		problemType.add(ProblemType.Core1);
		problemType.add(ProblemType.Core2);
		problemType.add(ProblemType.Core3b);
		problemType.add(ProblemType.Core3c);
		problemType.add(ProblemType.Core4);
		problemType.add(ProblemType.Core5);
	}

	public static LinkedList<ProblemType> getProblemType(){
		return problemType;
	}
}
