package br.com.kata.dao.impl;

import br.com.kata.domain.RomanNumeralsBase;

public interface ConverterDao {

	public RomanNumeralsBase findHighestRomanNumeralToDecimalNumber(int decimalNumber);
	
	public RomanNumeralsBase findHighestDecimalNumberToRomanNumeral(String romanNumeral);
	
	public int findDecimalNumberToRomanNumeral(String romanNumeral);
}
