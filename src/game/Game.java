package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	//TODO: determine if this should stay
	//private LinkedList<ProblemType> problemType;	//This is here to avoid a lot of if statements down the line
	
	public Game(){
		this.setJMenuBar(mainJMenuBar());
		setName("Fraction Fun!");
		setTitle("Fraction Fun!");
		setSize(SIZE + PADDING, SIZE + PADDING);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		board = new Board();
		display = new DisplayPanel();
		Game game = new Game();
		game.add(board, BorderLayout.CENTER);
		game.add(display, BorderLayout.SOUTH);
		game.setVisible(true);
		
		while(!board.checkOver()){
		}
		
		String message;
		if (Board.getPlayers().get(0).getLocation() == (Board.MAX_SIZE)){
			message = "You win the game!";
		} else {
			message = "The computer wins. You have want to brush up on the following Cores: TODO"; //TODO
		}
		JOptionPane.showMessageDialog(board, message);
		System.exit(1);
	}
	
	public static void checkAnswer(Problem problem){
		board.setCurrentProblem(problem);
		board.movePlayer();
		display.newDisplay();
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
	
}
