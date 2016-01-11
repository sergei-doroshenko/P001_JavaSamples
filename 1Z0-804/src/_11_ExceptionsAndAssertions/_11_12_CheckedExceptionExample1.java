package _11_ExceptionsAndAssertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class _11_12_CheckedExceptionExample1 {
	public static void main(String []args) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(args[0]);
	}
}  