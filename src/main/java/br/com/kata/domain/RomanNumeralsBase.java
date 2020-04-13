package br.com.kata.domain;

public class RomanNumeralsBase {
	private int decimalRepresentation;
	private String romanNumeralRepresentation;

	public RomanNumeralsBase() {
		super();
	}

	public RomanNumeralsBase(int decimalRepresentation, String romanNumeralRepresentation) {
		super();
		this.decimalRepresentation = decimalRepresentation;
		this.romanNumeralRepresentation = romanNumeralRepresentation;
	}

	public int getDecimalRepresentation() {
		return decimalRepresentation;
	}

	public void setDecimalRepresentation(int decimalRepresentation) {
		this.decimalRepresentation = decimalRepresentation;
	}

	public String getRomanNumeralRepresentation() {
		return romanNumeralRepresentation;
	}

	public void setRomanNumeralRepresentation(String romanNumeralRepresentation) {
		this.romanNumeralRepresentation = romanNumeralRepresentation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + decimalRepresentation;
		result = prime * result + ((romanNumeralRepresentation == null) ? 0 : romanNumeralRepresentation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RomanNumeralsBase other = (RomanNumeralsBase) obj;
		if (decimalRepresentation != other.decimalRepresentation)
			return false;
		if (romanNumeralRepresentation == null) {
			if (other.romanNumeralRepresentation != null)
				return false;
		} else if (!romanNumeralRepresentation.equals(other.romanNumeralRepresentation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RomansNumeralsBase [decimalRepresentation=" + decimalRepresentation + ", romanNumeralRepresentation="
				+ romanNumeralRepresentation + "]";
	}
}
