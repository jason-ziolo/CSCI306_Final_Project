package game;

@SuppressWarnings("serial")
public class ZeroDenomException extends Exception  {
	// Constructor with message passed in
	public ZeroDenomException(String message) {
		super(message);
	}
	
	public ZeroDenomException() {
		super("Denominator can't be zero");
	}
}
