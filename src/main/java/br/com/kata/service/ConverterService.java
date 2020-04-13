package br.com.kata.service;

import br.com.kata.dao.impl.ConverterDao;
import br.com.kata.domain.RomanNumeralsBase;
import br.com.kata.exceptions.MessagesExceptions;
import br.com.kata.exceptions.ValueExceedException;
import br.com.kata.exceptions.ValueNotPermittedException;

public class ConverterService {

	private String romanNumeralReturn;
	private ConverterDao converterDao;
	private int decimalNumberReturn;
	private int s1;
	
	public ConverterService(ConverterDao converterDao) {
		this.converterDao = converterDao;
	}

	public String convertDecimalToRomanNumeral(String decimalNumber) throws ValueNotPermittedException {
		String romanNumeralReturn = null;
		
		if (decimalNumber == null || "".equals(decimalNumber)) {
			throw new ValueNotPermittedException(MessagesExceptions.NUMBER_DOES_NOT_INFORMED);
		} else if (!decimalNumber.matches("^[0-9]*$")) {
			throw new ValueNotPermittedException(String.format(MessagesExceptions.VALUE_IS_NOT_VALID, decimalNumber));
		} else if ("0".contentEquals(decimalNumber)) {
			throw new ValueNotPermittedException(MessagesExceptions.VALUE_ZERO_IS_NOT_VALID);
		} else {
			int decimalNumberConverted = Integer.valueOf(decimalNumber);
			if(decimalNumberConverted > 3900) {
				throw new ValueExceedException(String.format(MessagesExceptions.VALUE_EXCEEDED, decimalNumberConverted));
			}
			this.romanNumeralReturn = "";
			romanNumeralReturn = this.buildRomanNumeral(decimalNumberConverted);
		}
		return romanNumeralReturn;
	}

	public int convertRomanNumeralToDecimal(String romanNumeral) throws ValueNotPermittedException {
		int decimalNumberReturn = 0;
		
		if (romanNumeral == null || "".equals(romanNumeral)) {
			throw new ValueNotPermittedException(MessagesExceptions.ROMAN_NUMERAL_DOES_NOT_INFORMED);
		} else if (!romanNumeral.matches("^[CDILMXV\\s]+$")) {
			throw new ValueNotPermittedException(String.format(MessagesExceptions.VALUE_IS_NOT_VALID, romanNumeral));
			
		} else {
			this.decimalNumberReturn = 0;
			decimalNumberReturn = this.buildDecimalNumber(romanNumeral, 0);
		}
		return decimalNumberReturn;
	}

	private String buildRomanNumeral(int decimalNumber) {
		
		if (decimalNumber == 0) {
			return this.romanNumeralReturn;
		} else {
			RomanNumeralsBase romansNumeralsBase = this.converterDao.findHighestRomanNumeralToDecimalNumber(decimalNumber);
			this.romanNumeralReturn = this.romanNumeralReturn+romansNumeralsBase.getRomanNumeralRepresentation();
			decimalNumber = decimalNumber - romansNumeralsBase.getDecimalRepresentation();
			buildRomanNumeral(decimalNumber);
		}
		
		return this.romanNumeralReturn;
	}

	private int buildDecimalNumber(String val, int index) {
		if (index >= val.length()) {
			return this.decimalNumberReturn;
		} else {
			s1 = this.converterDao.findDecimalNumberToRomanNumeral(val.substring(index, index + 1));
			if (index + 1 < val.length()) {
				int s2 = this.converterDao.findDecimalNumberToRomanNumeral(val.substring(index + 1, index + 2));
				
				if (s1 >= s2) {
					decimalNumberReturn = decimalNumberReturn + s1;
				} else {
					decimalNumberReturn = ((decimalNumberReturn + s2) - s1);
					index++;
				}
				index++;
				buildDecimalNumber(val, index);
			} else {
				decimalNumberReturn = decimalNumberReturn + s1;
				index++;
				buildDecimalNumber(val, index);
			}
		}
		return decimalNumberReturn;
	}
}
