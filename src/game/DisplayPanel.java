package game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayPanel extends JPanel{
		private JButton continueButton;
		private ProblemDisplay display;
		
		public DisplayPanel(){
			setLayout(new GridLayout(1,0));
			continueButton = new JButton("Continue");
			continueButton.addActionListener(new ButtonListener());
			add(continueButton);
			display = new ProblemDisplay();
		}
	
		public ProblemDisplay getDisplay() {
			return display;
		}
		
		public void newDisplay(){
			try {
				display.makeQuestion();
			} catch (ZeroDenomException e) {
				System.out.println(e.getMessage());
			}
		}


	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//System.out.println("Button Pressed");
			display.setVisible(true);
		}
	}
}