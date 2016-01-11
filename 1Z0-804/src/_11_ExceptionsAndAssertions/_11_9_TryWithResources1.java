package _11_ExceptionsAndAssertions;

import java.util.Scanner;

class _11_9_TryWithResources1 {
	public static void main(String [] args) {
		System.out.println("Type an integer in the console: ");
		try(Scanner consoleScanner = new Scanner(System.in)) { 
			System.out.println("You typed the integer value: " + consoleScanner.nextInt());
		} catch(Exception e) {
			// catch all other exceptions here ...
			System.out.println("Error: Encountered an exception and could not read an integer from the console... ");
			System.out.println("Exiting the program - restart and try the program again!");
		}
	}
}
