package game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		add(problem);
	}
	
	public void makeQuestion() throws ZeroDenomException{
		Random rand = new Random();
		int question = rand.nextInt(6) + 1;	//Change back to 6 + 1
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
		System.out.println(problem + " " + problem.getExpectedAnswer());
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
		private LinkedList<JButton> buttons = new LinkedList<JButton>();
		private ProblemDisplay display;
		private JTextField text;
		int answer = 0;
		
		public Numpad(ProblemDisplay display){
			this.display = display;
			this.setLayout(new GridLayout(0,3));
			buttons = new LinkedList<JButton>();
			addButton();
			for (JButton button : buttons){
				add(button);
			}
			updateAnswer();
			add(text);
		}
		
		public void updateAnswer(){
			String temp = "" + answer;
			text.setText(temp);
		}
		
		public void newButton(int pressed){
			answer = answer * 10 + pressed;
			updateAnswer();
		}
		
		public void resetAnswer(){
			answer = 0;
		}
		
		public void addButton(){
			for (int i = 0; i < 10; i++){
				String temp = "" + i;
				JButton button = new JButton(temp);
				button.addActionListener(new ButtonListener());
				buttons.add(button);
			}
			
			JButton button = new JButton("Submit");
			button.addActionListener(new ButtonListener());
			buttons.add(button);
			
			text = new JTextField(5);
			text.setEditable(false);
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
				} else if(numPressed == 10){
					display.getProblem().setAnswer(answer);
					resetAnswer();
					updateAnswer();
					Game.checkAnswer(problem);
					noDisplay();
				} else {
					newButton(numPressed);
				}
			}
		}
	}
}
