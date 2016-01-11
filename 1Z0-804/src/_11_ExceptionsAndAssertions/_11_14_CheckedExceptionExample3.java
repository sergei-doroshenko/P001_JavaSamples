package _11_ExceptionsAndAssertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class _11_14_CheckedExceptionExample3 {
	public static void main(String []args) {
		try {
			FileInputStream fis = new FileInputStream(args[0]);
		} catch(FileNotFoundException fnfe) {
			System.out.println("Error: There is no file that exists with name " + args[0]);
			System.out.println("Pass a valid file name as commandline argument!");
		}
	}
}