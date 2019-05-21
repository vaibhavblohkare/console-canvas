package com.cts.canvas;

import org.junit.Test;

import com.cts.canvas.bean.Shape;
import com.cts.canvas.command.ActionExecutorFactory;
import com.cts.canvas.command.ExecutorFactory;
import com.cts.canvas.exception.InvalidCommandException;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.exception.TerminateApplicationException;
import com.cts.canvas.utils.ConsoleUtil;

/**
 * Unit test for Canvas - Console App.
 */
public class ReviewerSampleExample {
	
	private static ActionExecutorFactory actExecutor;
    /**
     * Create the test case
     */
    public ReviewerSampleExample() {
        ReviewerSampleExample.actExecutor  = ExecutorFactory.getInstance().getActionExecutorFactory(App.class.getSimpleName());
    }
    
    @Test
    public void testCommandC() throws InvalidCommandInputException, InvalidCommandException, TerminateApplicationException {
    	ConsoleUtil.printMenu();
    	String commandLine = "C 20 4";
    	System.out.println("Enter command:"+commandLine);
    	Shape shape = new Shape();
        actExecutor.execute( shape ,commandLine);
        commandLine = "L 1 2 6 2";
        System.out.println("Enter command:"+commandLine);
        actExecutor.execute( shape ,commandLine);
        commandLine = "R 14 1 18 3";
        System.out.println("Enter command:"+commandLine);
        actExecutor.execute( shape ,commandLine);
        commandLine = "B 10 3 o";
        System.out.println("Enter command:"+commandLine);
        actExecutor.execute( shape ,commandLine);
       // commandLine = "Q";
       // System.out.println("Enter command:"+commandLine);
       // actExecutor.execute( shape ,commandLine);
    }
}
