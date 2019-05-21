package com.cts.canvas.exception;

public class InvalidCommandInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCommandInputException(String message) {
		super(message);
		System.out.println(message);
	}
}
