package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JFrame{
	private static Board board;
	private static DisplayPanel display;
	public static final int SIZE = 500;
	public static final int PADDING = 100;
	
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
		board.initialize();
		Game game = new Game();
		game.add(board, BorderLayout.CENTER);
		game.add(display, BorderLayout.SOUTH);
		game.setVisible(true);
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
