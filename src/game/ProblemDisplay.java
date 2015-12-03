package game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import game.Problems.Core1Problem;
import game.Problems.Core2Problem;
import game.Problems.Core3BProblem;
import game.Problems.Core3CProblem;
import game.Problems.Core4Problem;
import game.Problems.Core5Problem;

@SuppressWarnings("serial")
public class ProblemDisplay extends JDialog {
	public static final int HEIGHT = 500;
	public static final int WIDTH = 500;
	private Numpad pad;
	private Problem problem;

	public ProblemDisplay(){
		try {
			makeQuestion();
		} catch (ZeroDenomException e) {
			System.out.println(e.getMessage());
		}
		setName("Problem");
		setTitle("Problem");
		setSize(WIDTH, HEIGHT);
		this.setLayout(new GridLayout(0,2));
		pad = new Numpad(this);
		add(pad);
	}
	
	public void makeQuestion() throws ZeroDenomException{
		Random rand = new Random();
		int question = rand.nextInt(6) + 1;
		switch(question){
			case 1: setProblem(new Core1Problem());
					break;
			case 2: setProblem(new Core2Problem());
					break;
			case 3: setProblem(new Core3BProblem());
					break;
			case 4: setProblem(new Core3CProblem());
					break;
			case 5: setProblem(new Core4Problem());
					break;
			case 6: setProblem(new Core5Problem());
					break;
		}
		System.out.println(problem.getExpectedAnswer());
	}
	
	public void setProblem(Problem problem){
		this.problem = problem;
	}
	
	public Problem getProblem(){
		return problem;
	}
	
	public void noDisplay(){
		setVisible(false);
	}
	
	public class Numpad extends JPanel{
		private LinkedList<JButton> buttons;
		private ProblemDisplay display;
		
		public Numpad(ProblemDisplay display){
			this.display = display;
			buttons = new LinkedList<JButton>();
			this.setLayout(new GridLayout(0,3));
			addButton();
			for (JButton button : buttons){
				add(button);
			}
		}
		
		public void addButton(){
			for (int i = 0; i < 11; i++){
				String temp = "" + i;
				JButton button = new JButton(temp);
				button.addActionListener(new ButtonListener());
				buttons.add(button);
			}
			
			JButton button = new JButton("Exit");
			button.addActionListener(new ButtonListener());
			buttons.add(button);
		}
		
		public class ButtonListener implements ActionListener {
			private int numPressed;
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < buttons.size(); i++){
					if (e.getSource() == buttons.get(i)){
						numPressed = i;
						break;
					}
				}
				if (numPressed == 11){
					noDisplay();
				} else if(true){
					display.getProblem().setAnswer(numPressed);
					Game.checkAnswer(problem);
				}
			}
		}
	}
}
