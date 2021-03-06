package _11_ExceptionsAndAssertions;
// A simple progam to accept an integer from user in normal case, 
// otherwise prints an error message

import java.util.InputMismatchException;
import java.util.Scanner;

class _11_3_ScanInt2 {
	public static void main(String [] args) {
		System.out.println("Type an integer in the console: ");
		Scanner consoleScanner = new Scanner(System.in); 
		try { 
			System.out.println("You typed the integer value: " + consoleScanner.nextInt());
		} catch(InputMismatchException ime) { 
			// nextInt() throws InputMismatchException in case anything other than an integer 
			// is typed in the console; so handle it 
			System.out.println("Error: You typed some text that is not an integer value...");
			System.out.println("The calls in the stack trace are: ");
			for (StackTraceElement methodCall : ime.getStackTrace()) {
				System.out.println(methodCall);
			}
		}
	}
}
