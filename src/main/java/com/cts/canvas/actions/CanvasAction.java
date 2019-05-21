package com.cts.canvas.actions;

import com.cts.canvas.bean.Canvas;
import com.cts.canvas.bean.Shape;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.utils.Constants;

public class CanvasAction extends ActionExecutor{

	@Override
	public boolean doValidation(Shape shape) throws InvalidCommandInputException {
		String[] commandParams = shape.getParams();
		if(commandParams == null || commandParams.length != 2   ) {
			throw new InvalidCommandInputException("Invalid input for canvas creation \n"+Constants.CANVAS_HELP_MESSAGE);
		}
		if(Integer.parseInt(commandParams[0]) < 1 || Integer.parseInt(commandParams[1]) < 1) {
	        throw new InvalidCommandInputException("Canvas width and height can't be 0");
	    }
		return true;
	}

	@Override
	public void execute(Shape shape) throws Exception {
		shape.setCanvas( new Canvas(Integer.parseInt(shape.getParams()[0]),Integer.parseInt(shape.getParams()[1])));
        System.out.println(shape.getCanvas().render());
	}
}
