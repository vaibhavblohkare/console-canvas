package com.cts.canvas.exception;

public class CanvasNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CanvasNotFoundException(String message) {
        super(message);
        System.out.println(message);
    }
}
