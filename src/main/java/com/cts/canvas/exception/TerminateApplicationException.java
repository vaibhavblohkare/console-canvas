package com.cts.canvas.exception;

public class TerminateApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	
	public TerminateApplicationException(String message) {
		super(message);
		System.out.println(message);
	}
}
