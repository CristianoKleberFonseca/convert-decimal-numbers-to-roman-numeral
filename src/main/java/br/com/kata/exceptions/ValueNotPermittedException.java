package br.com.kata.exceptions;

public class ValueNotPermittedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValueNotPermittedException(String message) {
		super(message);
	}

}
