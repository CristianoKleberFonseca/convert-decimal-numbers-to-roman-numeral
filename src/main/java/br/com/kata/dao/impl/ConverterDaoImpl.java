package br.com.kata.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.kata.domain.RomanNumeralsBase;

public class ConverterDaoImpl implements ConverterDao {

	private static List<RomanNumeralsBase> romanNumeralsTable;

	static {
		romanNumeralsTable = new ArrayList<RomanNumeralsBase>(Arrays.asList(new RomanNumeralsBase(1, "I"),
				new RomanNumeralsBase(1, "I"), new RomanNumeralsBase(4, "IV"), new RomanNumeralsBase(5, "V"),
				new RomanNumeralsBase(9, "IX"), new RomanNumeralsBase(10, "X"), new RomanNumeralsBase(40, "XL"),
				new RomanNumeralsBase(50, "L"), new RomanNumeralsBase(90, "XC"), new RomanNumeralsBase(100, "C"),
				new RomanNumeralsBase(400, "CD"), new RomanNumeralsBase(500, "D"), new RomanNumeralsBase(900, "CM"),
				new RomanNumeralsBase(1000, "M")));
	}

	@Override
	public RomanNumeralsBase findHighestRomanNumeralToDecimalNumber(int decimalNumber) {
		RomanNumeralsBase romansNumeralsBaseReturn = null;

		for (RomanNumeralsBase romanNumeralsBase : romanNumeralsTable) {
			if (romanNumeralsBase.getDecimalRepresentation() <= decimalNumber) {
				romansNumeralsBaseReturn = romanNumeralsBase;
			}
		}

		return romansNumeralsBaseReturn;
	}

	@Override
	public RomanNumeralsBase findHighestDecimalNumberToRomanNumeral(String romanNumeral) {
		RomanNumeralsBase romansNumeralsBaseReturn = null;
		
		for (RomanNumeralsBase romanNumeralsBase : romanNumeralsTable) {
			if (romanNumeralsBase.getRomanNumeralRepresentation().equals(romanNumeral)) {
				return romanNumeralsBase;
			}
		}
		
		return romansNumeralsBaseReturn;
	}

	@Override
	public int findDecimalNumberToRomanNumeral(String romanNumeral) {
		int decimalNumberReturn = -1;
		
		RomanNumeralsBase romanNumeralsBase = this.findHighestDecimalNumberToRomanNumeral(romanNumeral);
		if(romanNumeralsBase != null) {
			decimalNumberReturn = romanNumeralsBase.getDecimalRepresentation();
		}
		
		return decimalNumberReturn;
	}
}
