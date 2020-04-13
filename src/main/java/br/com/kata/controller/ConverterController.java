package br.com.kata.controller;

import br.com.kata.dao.impl.ConverterDaoImpl;
import br.com.kata.exceptions.ValueNotPermittedException;
import br.com.kata.service.ConverterService;

public class ConverterController {
	private static ConverterController converterController = null;
	private ConverterService convertOrdinalToRomanService;
	
	private ConverterController() {
		this.convertOrdinalToRomanService = new ConverterService(new ConverterDaoImpl());
	}

	public static ConverterController getInstance() {
		if(converterController == null) {
			converterController = new ConverterController();
		}
		return converterController;
	}

	public String convertDecimalToRomanNumeral(String decimalNumber) throws ValueNotPermittedException {
		String romanNumeralReturn = this.convertOrdinalToRomanService.convertDecimalToRomanNumeral(decimalNumber);
		
		return romanNumeralReturn;
	}

	public int convertRomanNumeralToDecimal(String romanNumeral) throws ValueNotPermittedException {
		int decimalNumberReturn = this.convertOrdinalToRomanService.convertRomanNumeralToDecimal(romanNumeral);
		
		return decimalNumberReturn;
	}
}
