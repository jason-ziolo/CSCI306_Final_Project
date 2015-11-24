package game;

public class MixedNumber extends Fraction {
	private int wholeNumber;
	
	public MixedNumber(int num, int den, int wholeNumber) {
		super(num, den);
		wholeNumber = wholeNumber;
	}
	
	private double getValue() {
		return 0.0; //TODO
	}
	
	@Override
	public boolean equals(Fraction other) {
		return false; //TODO
	}

	public int getWholeNumber() {
		return wholeNumber;
	}

	public void setWholeNumber(int wholeNumber) {
		this.wholeNumber = wholeNumber;
	}
}
