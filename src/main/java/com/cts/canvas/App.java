package com.cts.canvas;

import java.util.Scanner;

import com.cts.canvas.bean.Shape;
import com.cts.canvas.command.ActionExecutorFactory;
import com.cts.canvas.command.ExecutorFactory;
import com.cts.canvas.exception.CanvasNotFoundException;
import com.cts.canvas.exception.InvalidCommandException;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.exception.TerminateApplicationException;
import com.cts.canvas.utils.ConsoleUtil;
import com.cts.canvas.utils.Constants;

/**
 * @author vaibhavLohkare
 *  Canvas - Console
 *
 */
public class App 
{
	private static ActionExecutorFactory actExecutor;
	private static Scanner scanner;
	private static Shape shape;

    public static void main( String[] args ) {
    	actExecutor = ExecutorFactory.getInstance().getActionExecutorFactory(App.class.getSimpleName());
    	scanner = new Scanner(System.in);
    	ConsoleUtil.printMenu();
    	shape = new Shape();
		while (true) {
			try {
				System.out.println("Enter command:");
	            String commandLine = scanner.nextLine();
	            actExecutor.execute( shape ,commandLine);
			} catch (CanvasNotFoundException | InvalidCommandException  | InvalidCommandInputException e) {
				continue;
			} catch (TerminateApplicationException e) {
				System.out.println(Constants.ABNORMAL_TERMINATION_MESSAGE);
				String command = scanner.nextLine();
				if(command!=null && "Y".equalsIgnoreCase(command)) {
					continue;
				}
				scanner.close();
		        System.exit(0);
			} 
		}
    }
}