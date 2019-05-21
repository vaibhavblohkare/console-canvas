package com.cts.canvas;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cts.canvas.bean.Canvas;
import com.cts.canvas.bean.Shape;
import com.cts.canvas.command.ActionExecutorFactory;
import com.cts.canvas.command.ExecutorFactory;
import com.cts.canvas.exception.CanvasNotFoundException;
import com.cts.canvas.exception.InvalidCommandException;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.utils.ConsoleUtil;
import com.cts.canvas.utils.Constants;


/**
 * Unit test for Canvas - Console App.
 */
public class AppTest{
	
	private static ActionExecutorFactory actExecutor;
    /**
     * Create the test case
     */
    public AppTest() {
        AppTest.actExecutor  = ExecutorFactory.getInstance().getActionExecutorFactory(App.class.getSimpleName());
    }
    	
    @Test
    public void testCommandC() throws Exception {
    	String commandLine = "C 20 4";
    	Shape shape = new Shape();
        actExecutor.execute( shape ,commandLine);
        String mainCommand = ConsoleUtil.getMainCommand(commandLine);
    	assertTrue( Constants.COMMAND_C.equals(mainCommand));
    	
        assertTrue(Integer.valueOf(shape.getParams()[0]) == 20);
    	assertTrue(Integer.valueOf(shape.getParams()[1]) == 4);
    }

    @Test
    public void testCommandL() throws Exception {
    	String commandLine = "L 1 2 6 2";
    	String mainCommand = ConsoleUtil.getMainCommand(commandLine);
    	Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
        actExecutor.execute( shape ,commandLine);
       
    	assertTrue( Constants.COMMAND_L.equals(mainCommand));
    	assertTrue(Integer.valueOf(shape.getParams()[0]) == 1);
    	assertTrue(Integer.valueOf(shape.getParams()[1]) == 2);
    	assertTrue(Integer.valueOf(shape.getParams()[2]) == 6);
    	assertTrue(Integer.valueOf(shape.getParams()[3]) == 2);
    }
    @Test
    public void testCommandR() throws Exception {
    	String commandLine = "R 14 1 18 3";
    	String mainCommand = ConsoleUtil.getMainCommand(commandLine);
    	Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	actExecutor.execute( shape ,commandLine);
    	assertTrue( Constants.COMMAND_R.equals(mainCommand));

    	assertTrue(Integer.valueOf(shape.getParams()[0]) == 14);
    	assertTrue(Integer.valueOf(shape.getParams()[1]) == 1);
    	assertTrue(Integer.valueOf(shape.getParams()[2]) == 18);
    	assertTrue(Integer.valueOf(shape.getParams()[3]) == 3);
    }
    @Test
    public void testCommandB() throws Exception {
    	String commandLine = "B 10 3 o";
    	
    	String mainCommand = ConsoleUtil.getMainCommand(commandLine);
    	Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	actExecutor.execute( shape ,commandLine);
    	
    	assertTrue( Constants.COMMAND_B.equals(mainCommand));

    	assertTrue(Integer.valueOf(shape.getParams()[0]) == 10);
    	assertTrue(Integer.valueOf(shape.getParams()[1]) == 3);
    	assertTrue(shape.getParams()[2].equals("o") );
    }
    
/* 		
 *    public void testCommandQ() throws InvalidCommandInputException, InvalidCommandException, TerminateApplicationException {
    	String commandLine = "Q";
    	String mainCommand = ConsoleUtil.getMainCommand(commandLine);
    	Shape shape = new Shape();

    	actExecutor.execute( shape ,commandLine);
    	
    	assertTrue( Constants.COMMAND_Q.equals(mainCommand));
    }
    */
    
    @Test(expected = InvalidCommandException.class)
    public void testForEmptyCommad() throws Exception {
    	String commandLine = " ";
    	Shape shape = new Shape();
        actExecutor.execute( shape ,commandLine);
    }
    
    @Test(expected = InvalidCommandException.class)
    public void testInvalidCommandException() throws Exception {
    	String commandLine = "A";
    	Shape shape = new Shape();
    	actExecutor.execute( shape ,commandLine);
    }
    
    @Test(expected = InvalidCommandInputException.class)
    public void testInvalidCommandInputException() throws Exception {
    	String commandLine = "C";
    	Shape shape = new Shape();
    	actExecutor.execute( shape ,commandLine);
    	
    }

    @Test(expected = CanvasNotFoundException.class)
    public void testCanvasNotFoundException() throws Exception {
    	String commandLine = "L 1 2 6 2";
    	Shape shape = new Shape();
    	actExecutor.execute( shape ,commandLine);
    }
}
