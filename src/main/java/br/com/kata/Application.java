package br.com.kata;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.kata.controller.ConverterController;

public class Application {
	private static ConverterController convertOrdinalToRomanController;
	private static final Logger logger = LogManager.getLogger(Application.class);

	public void displayMenu() {
		System.out.println("MENU: ");
		System.out.println("      1- ROMAN NUMERAL TO DECIMAL NUMBER");
		System.out.println("      2- DECIMAL NUMBER TO ROMAN NUMBER");
		System.out.println("      3-EXIT");
		System.out.println("Selection: ");
	}

	public static void main(String[] args) {
		boolean isEnd = false;
		Scanner scanner = new Scanner(System.in);
		String val = null;

		try {
			do {
				new Application().displayMenu();
				switch (scanner.nextInt()) {
				case 1:
					System.out.println("\n");
					System.out.println("Type a roman numeral: ");
					val = scanner.next();
					
					convertOrdinalToRomanController = ConverterController.getInstance();
					System.out.println("The decimal number is: " + convertOrdinalToRomanController.convertRomanNumeralToDecimal(val));
					System.out.println("\n");
					break;
				case 2:
					System.out.println("\n");
					System.out.println("Type an ordinal number: ");
					val = scanner.next();
					
					convertOrdinalToRomanController = ConverterController.getInstance();
					System.out.println("The roman numeral is: " + convertOrdinalToRomanController.convertDecimalToRomanNumeral(val));
					System.out.println("\n");
					break;
				case 3:
					System.out.println("\n");
					System.out.println("The system was ended.");
					isEnd = true;
					break;
				default:
					throw new Exception("Unrecognized option.");
				}
			
			} while (!isEnd);

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			scanner.close();
		}
	}

}
