package com.cts.canvas.actions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cts.canvas.bean.Canvas;
import com.cts.canvas.bean.Shape;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.utils.ConsoleUtil;

public class CanvasActionTest {
	@Test
    public void testCanvas() throws Exception {
		String commandLine = "C 20 4";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new CanvasAction().execute(shape);
    }

	
	@Test
    public void testCanvasWithAllValidInput() throws Exception {
		String commandLine = "C 20 4";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		assertTrue(new CanvasAction().doValidation(shape));
    }
	
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenNoInputForCanvasExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "C";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new CanvasAction().doValidation(shape);
    }
    
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenHeightAndWidthZeroForCanvasExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "C 0 0";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new CanvasAction().doValidation(shape);
    }
    
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenOnlySingleInputForCanvasExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "C 10";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new CanvasAction().doValidation(shape);
    }

    @Test(expected = InvalidCommandInputException.class)
    public void testWhenMoreThenTwoInputForCanvasExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "C 10 3 1";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new CanvasAction().doValidation(shape);
    }
    
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenMoreThenTwoInputForCanvasExpectedInvalidCommandInputException1() throws Exception {
    	String commandLine = "C A 3 1";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new CanvasAction().doValidation(shape);
    }
}

