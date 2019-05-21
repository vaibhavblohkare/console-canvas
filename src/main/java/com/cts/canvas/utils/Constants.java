package com.cts.canvas.utils;

public class Constants {
	
	
	public static final String 	COMMAND_C = "C";
	public static final String 	COMMAND_L = "L";
	public static final String 	COMMAND_R = "R";
	public static final String 	COMMAND_B = "B";
	public static final String 	COMMAND_Q = "Q";
	
	public static final String 	COMMAND_HELP_MESSAGE = "Kindly refer available command on top console. ";

	public static final String BUCKET_FILL_HELP_MESSAGE = "B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The\n" +
            "                behaviour of this is the same as that of the \"bucket fill\" tool in paint\n" +
            "                programs.";
	
	public static final String CANVAS_HELP_MESSAGE = "C w h           Should create a new canvas of width w and height h. w, h should be > 0";

	public static final String DRAW_LINE_HELP_MESSAGE = "L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n" +
	            "                horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
	            "                will be drawn using the 'x' character.";
	  
	public static final String DRAW_RECTANGLE_HELPMESSAGE = "R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n" +
	            "                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" +
	            "                using the 'x' character.";
	  
	public static final String QUIT_HELP_MESSAGE = "Q               Should quit the program.";
	
	public static final String ABNORMAL_TERMINATION_MESSAGE = "Sometings went wrong.Press Y to continue...";
	  
}
