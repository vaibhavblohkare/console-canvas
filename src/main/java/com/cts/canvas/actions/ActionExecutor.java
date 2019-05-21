package com.cts.canvas.actions;

import com.cts.canvas.bean.Shape;
import com.cts.canvas.exception.InvalidCommandInputException;

public abstract class ActionExecutor {
	
	public abstract boolean doValidation(Shape shape) throws InvalidCommandInputException;

	public abstract void execute(Shape shape) throws  Exception;
	
}
