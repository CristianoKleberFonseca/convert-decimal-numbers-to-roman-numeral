package br.com.kata;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.kata.controller.ConverterController;
import br.com.kata.exceptions.MessagesExceptions;
import br.com.kata.exceptions.ValueExceedException;
import br.com.kata.exceptions.ValueNotPermittedException;

public class ApplicationTest {
	int index;
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testConvertNumberWithSuccess() {
		ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
		String romanNumeral = convertOrdinalToRomanController.convertDecimalToRomanNumeral("627");
		
		assertThat(romanNumeral, is(equalTo("DCXXVII")));
	}
	
	@Test
	public void testConvertListOfNumbersWithSuccess() {
		List<String> listBaseDecimalNumbers = new ArrayList<String>(Arrays.asList("1","54","331","2085"));		
		String[] listBaseRomanNumeralsMatch = {"I","LIV","CCCXXXI","MMLXXXV"};
		String[] listBaseRomanNumerals = new String[4];
		
		listBaseDecimalNumbers.forEach(decimalNumber -> {
			ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
			String romanNumeral = "";
			romanNumeral = convertOrdinalToRomanController.convertDecimalToRomanNumeral(decimalNumber);
			listBaseRomanNumerals[this.index++] = romanNumeral;
		});
		assertArrayEquals(listBaseRomanNumeralsMatch, listBaseRomanNumerals);
	}
	
	@Test
	public void testNumberDoesNotInformedExpectedException() {
		ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
		
		expectedException.expect(ValueNotPermittedException.class);
		expectedException.expectMessage(MessagesExceptions.NUMBER_DOES_NOT_INFORMED);
		convertOrdinalToRomanController.convertDecimalToRomanNumeral(null);
	}
	
	@Test
	public void testValueIsNotValidExpectedException() {
		ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
		
		expectedException.expect(ValueNotPermittedException.class);
		expectedException.expectMessage(String.format(MessagesExceptions.VALUE_IS_NOT_VALID, "1U57"));
		convertOrdinalToRomanController.convertDecimalToRomanNumeral("1U57");
	}
	
	@Test
	public void testValueZeroExpectedException() {
		ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
		
		expectedException.expect(ValueNotPermittedException.class);
		expectedException.expectMessage(MessagesExceptions.VALUE_ZERO_IS_NOT_VALID);
		convertOrdinalToRomanController.convertDecimalToRomanNumeral("0");
	}
	
	@Test
	public void testDecimalValueExceedExpectedException() {
		ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
		
		expectedException.expect(ValueExceedException.class);
		expectedException.expectMessage(String.format(MessagesExceptions.VALUE_EXCEEDED, 4000));
		convertOrdinalToRomanController.convertDecimalToRomanNumeral("4000");
	}

	@Test
	public void testConvertRomanNumeralWithSuccess() {
		ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
		int decimalNumber = convertOrdinalToRomanController.convertRomanNumeralToDecimal("DCXXVII");
		
		assertThat(decimalNumber, is(equalTo(627)));
	}
	
	@Test
	public void testConvertListOfRomanNumeralsWithSuccess() {
		List<String> listBaseRomanNumerals = new ArrayList<String>(Arrays.asList("I","LIV","CCCXXXI","MMLXXXV"));
		int[] listBaseDecimalNumbersMatch = new int[]{1,54,331,2085};		
		int[] listBaseDecimalNumbers = new int[4];
		
		listBaseRomanNumerals.forEach(romanNumeral -> {
			ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
			int decimalNumber = 0;
			decimalNumber = convertOrdinalToRomanController.convertRomanNumeralToDecimal(romanNumeral);
			listBaseDecimalNumbers[this.index++] = decimalNumber;
		});
		assertArrayEquals(listBaseDecimalNumbersMatch, listBaseDecimalNumbers);
	}
	
	@Test
	public void testRomanNumeralDoesNotInformedExpectedException() {
		ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
		
		expectedException.expect(ValueNotPermittedException.class);
		expectedException.expectMessage(MessagesExceptions.ROMAN_NUMERAL_DOES_NOT_INFORMED);
		convertOrdinalToRomanController.convertRomanNumeralToDecimal(null);
	}
	
	@Test
	public void testRomanValueExceedException() {
		ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
		
		expectedException.expect(ValueNotPermittedException.class);
		expectedException.expectMessage(String.format(MessagesExceptions.ROMAN_NUMERAL_IS_NOT_VALID, "MMMMCMXCIX"));
		convertOrdinalToRomanController.convertRomanNumeralToDecimal("MMMMCMXCIX");
	}
	
	@Test
	public void testValueNotValidExpectedException() {
		ConverterController convertOrdinalToRomanController = ConverterController.getInstance();
		
		expectedException.expect(ValueNotPermittedException.class);
		expectedException.expectMessage(String.format(MessagesExceptions.ROMAN_NUMERAL_IS_NOT_VALID, "xIV"));
		convertOrdinalToRomanController.convertRomanNumeralToDecimal("xIV");
	}
}
