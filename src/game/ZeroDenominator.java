package game;

@SuppressWarnings("serial")
public class ZeroDenominator extends Exception  {
	// Constructor with message passed in
	public ZeroDenominator(String message) {
		super(message);
	}
	
	public ZeroDenominator() {
		super("Denominator can't be zero");
	}
}
