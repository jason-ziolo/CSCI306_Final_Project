package game;

public class MixedNumber {
	private int numerator;
	private int denomiator;
	private int wholeNumber;
	
	public MixedNumber(int num, int den, int wholeNumber) {
		numerator = num;
		denomiator = den;
		this.wholeNumber = wholeNumber;
	}
	
	public double getValue() {
		return 0.0; //TODO
	}
/*
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
*/

	public int getWholeNumber() {
		return wholeNumber;
	}
	
	public boolean equalsMixedNumber(MixedNumber mixed) {
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

	public Fraction toFraction() {
		Fraction result = new Fraction(this.getWholeNumber()*this.getDenominator() + this.getNumerator(), this.getDenominator());
		return result;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denomiator;
	}
}
