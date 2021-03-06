package _08_JavaIOFundamentals;

import java.io.Console;

// simple implementation of _8_1_Echo command
public class _8_1_Echo {
	public static void main(String []args) {
		// get the System console object 
		Console console = System.console();
		if(console == null) {
			System.err.println("Cannot retrive console object - are you running your application from an IDE? Exiting the application ... ");
			System.exit(-1); // terminate the application 
		}
		// read a line and print it through printf  
		console.printf(console.readLine());
	}
 }