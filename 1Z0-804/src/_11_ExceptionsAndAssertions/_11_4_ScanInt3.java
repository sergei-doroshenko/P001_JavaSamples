package _11_ExceptionsAndAssertions;
// A program that scans an integer from a given string 

import java.util.InputMismatchException;
import java.util.Scanner;

class _11_4_ScanInt3 {
public static void main(String [] args) {
		String integerStr = "100";
		System.out.println("The string to scan integer from it is: " + integerStr);
		Scanner consoleScanner = new Scanner(integerStr); 
		try { 
			System.out.println("The integer value scanned from string is: " + consoleScanner.nextInt());
		} catch(InputMismatchException ime) { 
			// nextInt() throws InputMismatchException in case anything other than an integer 
			// is provided in the string 
			System.out.println("Error: Cannot scan an integer from the given string");
		}
}
}
