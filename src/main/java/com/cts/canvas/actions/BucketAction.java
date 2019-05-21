package com.cts.canvas.actions;

import com.cts.canvas.bean.Shape;
import com.cts.canvas.exception.CanvasNotFoundException;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.utils.Constants;

public class BucketAction extends ActionExecutor{

	@Override
	public boolean doValidation(Shape shape) throws InvalidCommandInputException {
		if(shape.getCanvas() == null) {
            throw new CanvasNotFoundException("Draw a canvas first");
		}
		String[] commandParams = shape.getParams();
		if(commandParams == null || commandParams.length != 3 ) {
			throw new InvalidCommandInputException("Invalid input for bucket fill command  \n"+Constants.BUCKET_FILL_HELP_MESSAGE);
		}
		return true;
	}

	@Override
	public void execute(Shape shape) throws  Exception {
		shape.getCanvas().bucketFill(Integer.parseInt(shape.getParams()[0]),Integer.parseInt(shape.getParams()[1]),shape.getParams()[2].charAt(0));
    	System.out.println(shape.getCanvas().render());
	}

}
