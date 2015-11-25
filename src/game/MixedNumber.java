package game;

public class MixedNumber extends Fraction {
	private int wholeNumber;
	
	public MixedNumber(int num, int den, int wholeNumber) {
		super(num, den);
		wholeNumber = wholeNumber;
	}
	
	public double getValue() {
		return 0.0; //TODO
	}

	public boolean equals(Fraction fraction) {
		if ((this.getValue() - fraction.getValue()) < TOLERANCE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean equals(MixedNumber mixed) {
		if ((this.getValue() - mixed.getValue()) < TOLERANCE) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getWholeNumber() {
		return wholeNumber;
	}

	public void setWholeNumber(int wholeNumber) {
		this.wholeNumber = wholeNumber;
	}
}
