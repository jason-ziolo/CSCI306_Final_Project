package game;

public class MixedNumber extends Fraction {
	private int wholeNumber;
	
	public MixedNumber(int num, int den, int wholeNumber) throws ZeroDenomException {
		super(num, den);
		this.wholeNumber = wholeNumber;
	}
	
	public double getValue() throws ZeroDenomException {
		return this.getFraction().getValue();
	}

	public boolean equals(Fraction fraction) throws ZeroDenomException {
		return fraction.equals(this);
	}

	public int getWholeNumber() {
		return wholeNumber;
	}
	
	public boolean equals(MixedNumber mixed) {
		int thisNumerator = this.getWholeNumber()*this.getDenominator() + this.getNumerator();
		int mixedNumerator = mixed.getWholeNumber()*mixed.getDenominator() + mixed.getNumerator();
		if (thisNumerator*mixed.getDenominator() == this.getDenominator()*mixedNumerator) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setWholeNumber(int wholeNumber) {
		this.wholeNumber = wholeNumber;
	}

	public Fraction toFraction() throws ZeroDenomException {
		Fraction result = new Fraction(this.getWholeNumber()*this.getDenominator() + this.getNumerator(), this.getDenominator());
		return result;
	}
}
