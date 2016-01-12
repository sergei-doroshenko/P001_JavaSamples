package _11_ExceptionsAndAssertions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class _11_20_ThrowsClause2 {
	public static void main(String []args) throws FileNotFoundException {
		System.out.println("Reading an integer from the file 'integer.txt': ");
		Scanner consoleScanner = new Scanner(new File("integer.txt")); 
		System.out.println("You typed the integer value: " + consoleScanner.nextInt());
	}
}
  