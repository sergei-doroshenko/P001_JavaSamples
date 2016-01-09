package _11_ExceptionsAndAssertions;
// A program that illustrates multi-catch blocks 

import java.util.NoSuchElementException;
import java.util.Scanner;

class _11_6_ScanInt5 {
	public static void main(String [] args) {
		String integerStr = ""; 
		System.out.println("The string to scan integer from it is: " + integerStr);
		Scanner consoleScanner = new Scanner(integerStr); 
		try { 
			System.out.println("The integer value scanned from string is: " +  	consoleScanner.nextInt());
		} catch(NoSuchElementException | IllegalStateException multie) { 
			System.out.println("Error: An error occurred while attempting to scan the integer");
		}
	}
}