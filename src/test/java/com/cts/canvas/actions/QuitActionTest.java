package com.cts.canvas.actions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cts.canvas.bean.Shape;
import com.cts.canvas.utils.ConsoleUtil;

public class QuitActionTest {
	
	
/*	unable to run due to System.exit(0);
	@Test
    public void testQuit() throws Exception {
		String commandLine = "Q";
		Shape shape = new Shape();
    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		new QuitAction().execute(shape);
    }
*/
	
	@Test
    public void testQuitWithAllValidInput() throws Exception {
		String commandLine = "Q";
		Shape shape = new Shape();
//    	shape.setCanvas(new Canvas(20,4));
    	shape.setParams(ConsoleUtil.getCommandParams(commandLine));
		assertTrue(new QuitAction().doValidation(shape));
    }
	
}

