package game;

public class Fraction {
	protected int numerator;
	protected int denominator;
	
	public Fraction(int num, int den) {
		numerator = num;
		denominator = den;
	}
	
	private double getValue() {
		return 0.0; //TODO
	}
	
	public boolean equals(Fraction fraction) {
		if (this.getNumerator()*fraction.getDenominator() == this.getDenominator()*fraction.getNumerator()) {
			return true;
		}
		else {
			return false;
		}
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

	public int getWholeNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean commonDenominator(Fraction fraction) {
		if (this.getDenominator() == fraction.getDenominator()) {
			return true;
		}
		else {
			return false;
		}
	}

	public int leastCommonDenominator(Fraction fraction) {
		if (this.getDenominator() > fraction.getDenominator()) {
			if (this.getDenominator() % fraction.getDenominator() == 0) {
				return this.getDenominator();
			}
			else {
				return this.getDenominator()*fraction.getDenominator();
			}
		}
		else if (this.getDenominator() < fraction.getDenominator()) {
			if (fraction.getDenominator() % this.getDenominator() == 0) {
				return fraction.getDenominator();
			}
			else {
				return this.getDenominator()*fraction.getDenominator();
			}
		}
		else if (this.getDenominator() == fraction.getDenominator()) {
			return this.getDenominator();
		}
		return 0;
	}

	public Fraction changeDenomiator(int denominator) {
		int n = denominator / this.getDenominator();
		this.setNumerator(this.getNumerator()*n);
		this.setDenominator(this.getDenominator()*n);
		return this;
	}

	public Fraction addition(Fraction fraction) {
		if (this.denominator == fraction.denominator) {
			this.setNumerator(this.getNumerator() + fraction.getNumerator());
			this.setDenominator(this.getDenominator());
			return this;
		}
		else {
			this.changeDenomiator(fraction.getDenominator());
			this.addition(fraction);
			System.out.println("Wrong");
			return null;
		}
	}
}
