package com.cts.canvas.command;


import java.util.HashMap;
import java.util.Map;

import com.cts.canvas.actions.ActionExecutor;
import com.cts.canvas.actions.BucketAction;
import com.cts.canvas.actions.CanvasAction;
import com.cts.canvas.actions.LineAction;
import com.cts.canvas.actions.QuitAction;
import com.cts.canvas.actions.RectangleAction;
import com.cts.canvas.bean.Shape;
import com.cts.canvas.exception.CanvasNotFoundException;
import com.cts.canvas.exception.InvalidCommandException;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.exception.TerminateApplicationException;
import com.cts.canvas.utils.ConsoleUtil;
import com.cts.canvas.utils.Constants;

public class ActionExecutorFactory {
	/**
	 * ActionExecutor map
	 */

	private static Map<String, ActionExecutor> actionMap;
	
	/**
	 * constructor
	 */
	ActionExecutorFactory() {
	actionMap = new HashMap<String, ActionExecutor>();
	init();
	}
	private static void init() {
		addAction(Constants.COMMAND_C, new CanvasAction());
		addAction(Constants.COMMAND_L, new LineAction());
		addAction(Constants.COMMAND_R, new RectangleAction());
		addAction(Constants.COMMAND_B, new BucketAction());
		addAction(Constants.COMMAND_Q, new QuitAction());
	}
	public static void addAction(String name, ActionExecutor executor) {
		if (!actionMap.containsKey(name)) {
			actionMap.put(name.toUpperCase(), executor);
		}
	}

	/**
	 * A method which will return actionExecutor as per command available in command line.
	 * @param shape 
	 * @param commandLine input from scanner
	 * @throws InvalidCommandException 
	 * @throws InvalidCommandInputException 
	 * @throws TerminateApplicationException 
	 */
	public void execute(Shape shape, String commandLine) throws  InvalidCommandException, InvalidCommandInputException, TerminateApplicationException {
		try {
			String type = ConsoleUtil.getMainCommand(commandLine);
			ActionExecutor executor = actionMap.get(type);
			
			if(executor == null) {
				throw new InvalidCommandException("Invalid Command\n"+Constants.COMMAND_HELP_MESSAGE);
			}else {
            	shape.setParams( ConsoleUtil.getCommandParams(commandLine));
				if(executor.doValidation(shape)) {
					executor.execute(shape);
				}
			}
		} catch (InvalidCommandException | InvalidCommandInputException | CanvasNotFoundException e) {
			throw e;
		}catch( Exception e) {
			throw new TerminateApplicationException(Constants.ABNORMAL_TERMINATION_MESSAGE);
		} 
	}
}

