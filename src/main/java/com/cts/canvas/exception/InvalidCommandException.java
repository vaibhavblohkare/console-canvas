package com.cts.canvas.exception;

public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCommandException(String message) {
		super(message);
		System.out.println(message);
	}
}
