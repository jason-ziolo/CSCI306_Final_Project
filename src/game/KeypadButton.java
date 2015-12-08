package game;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class KeypadButton extends JButton {
	// Two reasons why we need this class
	// We need to be able to assign integer values to the buttons on the keypad
	private int numValue;
	
	public KeypadButton(int numValue, String name) {
		super(name);
		this.numValue = numValue;
		this.setName(name);
	}

	public int getNumValue() {
		return numValue;
	}
}
