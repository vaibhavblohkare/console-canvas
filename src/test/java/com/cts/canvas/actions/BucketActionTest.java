package com.cts.canvas.actions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.cts.canvas.bean.Canvas;
import com.cts.canvas.bean.Shape;
import com.cts.canvas.exception.CanvasNotFoundException;
import com.cts.canvas.exception.InvalidCommandInputException;
import com.cts.canvas.utils.ConsoleUtil;

public class BucketActionTest {
	@Test
    public void testBucketFill() throws Exception {
		String commandLine = "B 10 3 o";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new BucketAction().execute(shape);
    }
	
	@Test
    public void testBucketFillWithAllValidInput() throws Exception {
		String commandLine = "B 10 3 o";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		assertTrue(new BucketAction().doValidation(shape));
    }
	
    @Test(expected = CanvasNotFoundException.class)
    public void testForCanvasNotFoundException() throws Exception {
    	String commandLine = "B 10 3 o";
		Shape shape = new Shape();
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new BucketAction().doValidation(shape);
		fail("Expected InvalidCommandException when command is A");
    }

    @Test(expected = InvalidCommandInputException.class)
    public void testWhenNoInputForFillBucketExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "B";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new BucketAction().doValidation(shape);
    }
    
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenOnlySingleInputForFillBucketExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "B 10";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new BucketAction().doValidation(shape);
    }

    @Test(expected = InvalidCommandInputException.class)
    public void testWhenOnlyTwoInputForFillBucketExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "B 10 3 ";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new BucketAction().doValidation(shape);
    }
  /*  
    @Test(expected = InvalidCommandInputException.class)
    public void testWhenInvalidCharacterInputForFillBucketExpectedInvalidCommandInputException() throws Exception {
    	String commandLine = "B 10 3 1";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new BucketAction().doValidation(shape);
    }
	*/
}

