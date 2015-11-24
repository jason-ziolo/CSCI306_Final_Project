package game;

public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int num, int den) {
		numerator = num;
		denominator = den;
	}
	
	private double getValue() {
		return 0.0; //TODO
	}
	
	public boolean equals(Fraction other) {
		return false; //TODO
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
}
