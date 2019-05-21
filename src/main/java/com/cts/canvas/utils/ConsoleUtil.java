package com.cts.canvas.utils;

import java.util.Arrays;

public class ConsoleUtil {

	 public static void printMenu() {
	  
	        System.out.println("******************************************");
	        System.out.println("*                  MENU                  *");
	        System.out.println("******************************************");
	        System.out.println("*                                        *");
	        System.out.println("*   1) C w h          to create a convas *");
	        System.out.println("*   2) L x1 y1 x2 y2  to draw a line     *");
	        System.out.println("*   3) R x1 y1 x2 y2  to draw rectangle  *");
	        System.out.println("*   4) B x1 y1 color  to refill          *");
	        System.out.println("*                                        *");
	        System.out.println("******************************************");
	        System.out.println("*   5) Q              to Exit            *");
	        System.out.println("******************************************");
	 }
	 
	 public static String getMainCommand(String commandLine ) {
		 String mainCommand = null;
		 commandLine = commandLine.trim().replaceAll(" {2}", " ");
         String[] split  = commandLine.split(" ");
         if(split.length > 0) {
         	mainCommand = split[0].toUpperCase();	
         }
		 return mainCommand;
	 }
	 
	 public static String[] getCommandParams(String commandLine ) {
		 String[] params = null ;
		 commandLine = commandLine.trim().replaceAll(" {2}", " ");
         String[] split  = commandLine.split(" ");
         if(split.length > 0) {
         	params   = Arrays.copyOfRange(split, 1, split.length);
         }
		 return params;
	 }
}
