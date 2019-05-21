package com.cts.canvas.actions;

import com.cts.canvas.bean.Shape;
import com.cts.canvas.exception.CanvasNotFoundException;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.utils.Constants;

public class RectangleAction extends ActionExecutor{

	@Override
	public boolean doValidation(Shape shape) throws InvalidCommandInputException {
		
		if(shape.getCanvas() == null) {
            throw new CanvasNotFoundException("Draw a canvas first");
		}
		String[] commandParams = shape.getParams();
		if(commandParams == null || commandParams.length != 4   ) {
			throw new InvalidCommandInputException("Invalid input for Rectangle  \n"+Constants.DRAW_RECTANGLE_HELPMESSAGE);
		}
		return true;
	}

	@Override
	public void execute(Shape shape) throws Exception {
		shape.getCanvas().drawRectangle(Integer.parseInt(shape.getParams()[0]),Integer.parseInt(shape.getParams()[1]),Integer.parseInt(shape.getParams()[2]),Integer.parseInt(shape.getParams()[3]),'X');
        System.out.println(shape.getCanvas().render());
	}
}
