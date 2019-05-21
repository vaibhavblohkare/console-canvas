package com.cts.canvas.actions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cts.canvas.bean.Canvas;
import com.cts.canvas.bean.Shape;
import com.cts.canvas.exception.CanvasNotFoundException;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.utils.ConsoleUtil;

public class LineActionTest {
	@Test
    public void testLine() throws Exception {
		String commandLine = "L 1 2 6 2";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new LineAction().execute(shape);
    }

	
	@Test
    public void testLineWithAllValidInput() throws Exception {
		String commandLine = "L 1 2 6 2";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		assertTrue(new LineAction().doValidation(shape));
    }
	
    @Test(expected = CanvasNotFoundException.class)
    public void testForCanvasNotFoundException() throws Exception {
    	String commandLine = "L 1 2 6 2";
		Shape shape = new Shape();
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new LineAction().doValidation(shape);
    }

    @Test(expected = InvalidCommandInputException.class)
    public void testWhenNoInputForLineExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "L";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new LineAction().doValidation(shape);
    }
    
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenOnlySingleInputForLineExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "L 10";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new LineAction().doValidation(shape);
    }

    @Test(expected = InvalidCommandInputException.class)
    public void testWhenOnlyTwoInputForLineExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "L 10 3 ";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new LineAction().doValidation(shape);
    }
    
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenOnlyThreeInputForLineExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "L 10 3 1";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new LineAction().doValidation(shape);
    }
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenOnlyThreeInputForLineExpectedInvalidCommandInputException1() throws Exception {
    	String commandLine = "L 10 30 100";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new LineAction().doValidation(shape);
    }
}

