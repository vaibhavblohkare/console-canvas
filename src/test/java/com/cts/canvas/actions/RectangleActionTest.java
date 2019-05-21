package com.cts.canvas.actions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cts.canvas.bean.Canvas;
import com.cts.canvas.bean.Shape;
import com.cts.canvas.exception.CanvasNotFoundException;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.utils.ConsoleUtil;

public class RectangleActionTest {
	@Test
    public void testRectangle() throws Exception {
		String commandRectangle = "R 14 1 18 3";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandRectangle));
		new RectangleAction().execute(shape);
    }

	
	@Test
    public void testRectangleWithAllValidInput() throws Exception {
		String commandRectangle = "R 14 1 18 3";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandRectangle));
		assertTrue(new RectangleAction().doValidation(shape));
    }
	
    @Test(expected = CanvasNotFoundException.class)
    public void testForCanvasNotFoundException() throws Exception {
    	String commandRectangle = "R 14 1 18 3";
		Shape shape = new Shape();
    	shape.setParams(ConsoleUtil.getCommandParams(commandRectangle));
		new RectangleAction().doValidation(shape);
    }

    @Test(expected = InvalidCommandInputException.class)
    public void testWhenNoInputForRectangleExpectedInvalidCommandInputException() throws Exception {
    	String commandRectangle = "R";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandRectangle));
		new RectangleAction().doValidation(shape);
    }
    
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenOnlySingleInputForRectangleExpectedInvalidCommandInputException() throws Exception {
    	String commandRectangle = "R 10";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandRectangle));
		new RectangleAction().doValidation(shape);
    }

    @Test(expected = InvalidCommandInputException.class)
    public void testWhenOnlyTwoInputForRectangleExpectedInvalidCommandInputException() throws Exception {
    	String commandRectangle = "R 10 3 ";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandRectangle));
		new RectangleAction().doValidation(shape);
    }
    
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenOnlyThreeInputForRectangleExpectedInvalidCommandInputException() throws Exception {
    	String commandRectangle = "R 10 3 1";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandRectangle));
		new RectangleAction().doValidation(shape);
    }
}

