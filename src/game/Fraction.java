package game;

public class Fraction {
	protected int numerator;
	protected int denominator;
	
	public Fraction(int num, int den) throws ZeroDenomException {
		numerator = num;
		denominator = den;
		if (denominator == 0)
			throw new ZeroDenomException();
	}
	
	public double getValue() throws ZeroDenomException {
		return (double)this.numerator / (double)this.denominator;
	}
	
	public boolean equals(Fraction fraction) throws ZeroDenomException {
		if (this.getNumerator()*fraction.getDenominator() == this.getDenominator()*fraction.getNumerator()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean equals(MixedNumber mixed) throws ZeroDenomException {
		Fraction compare = mixed.toFraction();
		return this.equals(compare);
	}
	
	public Fraction getFraction() throws ZeroDenomException{
		return new Fraction(numerator, denominator);
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

	public void setDenominator(int denominator) throws ZeroDenomException {
		if (denominator == 0){
			throw new ZeroDenomException();
		}
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

	public Fraction changeDenomiator(int denominator) throws ZeroDenomException {
		int n = denominator / this.getDenominator();
		this.setNumerator(this.getNumerator()*n);
		this.setDenominator(this.getDenominator()*n);
		return this;
	}

	public Fraction addition(Fraction fraction) throws ZeroDenomException {
		if (this.denominator == fraction.denominator) {
			this.setNumerator(this.getNumerator() + fraction.getNumerator());
			this.setDenominator(this.getDenominator());
			return this;
		}
		else {
			int lcd = this.leastCommonDenominator(fraction);
			this.changeDenomiator(lcd);
			fraction.changeDenomiator(lcd);
			this.setNumerator(this.getNumerator() + fraction.getNumerator());
			this.setDenominator(this.getDenominator());
			return this;
		}
	}

	public MixedNumber toMixedNumber() throws ZeroDenomException {
		int numerator = this.getNumerator() % this.getDenominator();
		if (this.getNumerator() > this.getDenominator()) {
			MixedNumber result = new MixedNumber(numerator, this.getDenominator(),(this.getNumerator() - numerator) / this.denominator);
			return result;
		}
		else if (this.getNumerator() < this.getDenominator()) {
			MixedNumber result = new MixedNumber(this.getNumerator(), this.getDenominator(),0);
			return result;
		}
		else if (this.getNumerator() == this.getDenominator()) {
			MixedNumber result = new MixedNumber(1, 1, 0);
			return result;
		}
		return null;
	}

	public Fraction intMultiplication(int wholeNumber) {
		this.setNumerator(this.getNumerator()*wholeNumber);
		return this;
	}
}
