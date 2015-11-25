package game;

public class Fraction {
	public final static double TOLERANCE = 0.0001;
	protected int numerator;
	protected int denominator;
	
	public Fraction(int num, int den) {
		numerator = num;
		denominator = den;
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
			/* TODO
			this.changeDenomiator(fraction.getDenominator());
			this.addition(fraction);
			System.out.println("Wrong");
			*/
			return null;
		}
	}
	
	public Fraction multiply(int factor) {
		return null; // TODO	
	}
}
