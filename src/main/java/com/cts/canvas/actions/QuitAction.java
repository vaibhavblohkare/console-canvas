package com.cts.canvas.actions;

import com.cts.canvas.bean.Shape;

public class QuitAction extends ActionExecutor{

	@Override
	public boolean doValidation(Shape shape) {
		return true;
	}

	@Override
	public void execute(Shape shape) throws Exception {
		System.out.println("Quitting....Have a nice day!");
		System.exit(0);
	}

}
